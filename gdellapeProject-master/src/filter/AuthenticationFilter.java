package filter;

import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    private ServletContext context;
    public Integer tipo;
    public String Url;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter init");
        this.tipo = 0;
        this.Url = " ";
    }

    private void disattivaOfferta(Azienda azienda){
        Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
        Boolean scaduto = (Boolean) scadenza.get("scaduto");
        if(scaduto){
            OffertaTirocinioDaoImp offertaTirocinioDaoImp =new OffertaTirocinioDaoImp();
            try {
                List<OffertaTirocinio> offerteTirocinio= offertaTirocinioDaoImp.getOffertatrBYAzienda(azienda);
                offertaTirocinioDaoImp.destroy();
                for (OffertaTirocinio offerta: offerteTirocinio) {
                    offerta.setStato(0);
                    OffertaTirocinioDaoImp offertaTirocinioDaoImp1 = new OffertaTirocinioDaoImp();
                    offertaTirocinioDaoImp1.updateOffertatr(offerta);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }

        }
    }

    private  void checkScadenzaAzineda(Azienda azienda, HttpServletRequest request){
        Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
        Boolean scaduto = (Boolean) scadenza.get("scaduto");
        if(scaduto){
            AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
            azienda.setAttivo(0);
            try {
                aziendaDaoImp.updateAzienda(azienda);
                aziendaDaoImp.destroy();
                request.setAttribute("Scaduto", true);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } else request.setAttribute("Scaduto", false);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Il filtro FiltroAutenticator ha ricevuto la richiesta dal client");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        req.setAttribute("tipo", tipo);

        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isValidSession(req)) {
            if (session.isAdmin(req)) {
                this.tipo = 1;
                req.setAttribute("tipo", tipo);
                chain.doFilter(request, response);
            } else if (session.isAzienda(req)) {
                this.tipo = 3;
                req.setAttribute("tipo", tipo);
                Azienda azienda = session.getAzienda(req, res);
                if (azienda.getAttivo() == 1){
                    checkScadenzaAzineda(azienda, req);
                    disattivaOfferta(azienda);
                } else req.setAttribute("Scaduto", true);
                chain.doFilter(request, response);
            } else if (session.isTirocinante(req)) {
                this.tipo = 2;
                req.setAttribute("tipo", tipo);
                chain.doFilter(request, response);
            } else res.sendRedirect(req.getContextPath() + "/login");
        } else {
            this.context.log("accesso non autorizzato");
            System.out.println("accesso non autorizzato filtro");
            System.out.println(req.getRequestURI()+"?"+req.getQueryString());
            this.Url = req.getRequestURL()+"?"+req.getQueryString();
            session.destroy(req);
            HttpSession session1= req.getSession();
            session1.setAttribute("URI", Url);
            res.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    public void destroy() {

    }
}
