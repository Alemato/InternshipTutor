package filter;

import controller.sessionController.SingSessionContoller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    private ServletContext context;
    public Integer tipo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter init");
        this.tipo = 0;
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
                chain.doFilter(request, response);
            } else if (session.isTirocinante(req)) {
                this.tipo = 2;
                req.setAttribute("tipo", tipo);
                chain.doFilter(request, response);
            }
        } else {
            this.context.log("accesso non autorizzato");
            System.out.println("accesso non autorizzato filtro");
            res.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    public void destroy() {

    }
}
