package filter;

import javax.servlet.*;
import java.io.IOException;

public class AdmistrationFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig config) throws ServletException {
     this.context=config.getServletContext();

    }

    public void destroy() {
    }
    //Todo prova se funziona l'errore
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(req.getAttribute("tipo").equals(1))
        {
            chain.doFilter(req, resp);
        }else{
           RequestDispatcher requestDispatcher= context.getRequestDispatcher("/500");
           requestDispatcher.forward(req,resp);
        }

    }



}
