package filter;

import javax.servlet.*;
import java.io.IOException;

public class AdmistrationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(Integer.parseInt(req.getParameter("tipo"))==1)
        {
            chain.doFilter(req, resp);
        }else{
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("/403");
            requestDispatcher.forward(req,resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
