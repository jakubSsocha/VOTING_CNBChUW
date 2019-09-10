package Servlets.logers;

import DAO.User_DAO;
import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Logger")
public class Logger extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User_DAO user_dao = new User_DAO();
        User user = user_dao.read(email);
        String isUserAdmin=user.getAdmin_status();

        if (user != null) {
            if (user.getUser_password().equals(password)) {
                if (user.getStatus().equals("active")) {
                    HttpSession sess=request.getSession();
                    sess.setAttribute("isUserAdmin",isUserAdmin);
                    getServletContext().getRequestDispatcher("/Director").forward(request, response);
                    return;
                } else {
                    response.sendRedirect("http://localhost:8080/voting_war_exploded/startInactiveAccount.jsp");
                    return;
                }
            } else {
                response.sendRedirect("http://localhost:8080/voting_war_exploded/startWrongPassword.jsp");
                return;
            }
        }
        response.sendRedirect("http://localhost:8080/voting_war_exploded/startNoUser.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://localhost:8080/voting_war_exploded/startLogin.jsp");
    }
}
