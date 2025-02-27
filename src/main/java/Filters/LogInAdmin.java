package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class LogInAdmin implements Filter {

    private final String accessDenied= "Brak dostępu! Zaloguj się na konto administratora!";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && (boolean)session.getAttribute("isUserAdmin") == true);
        if (isLoggedIn) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(httpRequest.getContextPath()+"/index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
