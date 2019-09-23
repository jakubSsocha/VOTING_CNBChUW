package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter({"/UsersMenu.jsp", "/adminMenu.jsp", "/headerAdmin.jsp", "/ResultsMenu.jsp", "/SelectUsersMenu.jsp", "/VotingsMenu.jsp"})
public class JspDisable implements Filter {

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
            response.sendRedirect(httpRequest.getContextPath()+"/startLogin.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
