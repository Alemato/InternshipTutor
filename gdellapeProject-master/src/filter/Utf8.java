package filter;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Utf8 implements Filter {

    public Utf8() {
//Costruttore
    }

    public void init(FilterConfig config) {
//Metodo per l'inizializzazione del filtro
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
//Applicazione del filtro
        if (request.getCharacterEncoding() == null) {
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException ignored) {
            }
        }

//Si passa il tutto alla sottostante catena di filtri
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException ignored) {
        }
    }

    public void destroy() {
//Metodo per la distruzione del filtro
    }
}