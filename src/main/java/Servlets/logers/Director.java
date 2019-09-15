package Servlets.logers;

import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Director")
public class Director extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        boolean isAdminStatus = (boolean) sess.getAttribute("isUserAdmin");
        if (isAdminStatus) {
            response.sendRedirect("http://localhost:8080/voting_war_exploded/adminMenu.jsp");
        } else {
            response.sendRedirect("http://localhost:8080/voting_war_exploded/userStart.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
