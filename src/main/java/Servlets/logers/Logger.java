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

        final String inactiveAccount= "Konto nieaktywne! Skontaktuj się z administratorem!";
        final String wrongPassword = "Sprawdź dane logowania!";
        final String userDoesNotExist= "Nie zarejestrowano użytkownika!";

        User_DAO user_dao = new User_DAO();
        User user = user_dao.read(email);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                if (user.isActive()) {
                    boolean isUserAdmin=user.isAdmin();
                    HttpSession sess=request.getSession();
                    sess.setAttribute("isUserAdmin",isUserAdmin);
                    sess.setAttribute("id",user.getId());
                    getServletContext().getRequestDispatcher("/Director").forward(request, response);
                    return;
                } else {
                    request.setAttribute("text",inactiveAccount);
                    response.sendRedirect("http://localhost:8080/voting_war_exploded/ApStart");
                    return;
                }
            } else {
                request.setAttribute("text",wrongPassword);
                response.sendRedirect("http://localhost:8080/voting_war_exploded/ApStart");
                return;
            }
        }
        request.setAttribute("text",userDoesNotExist);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://localhost:8080/voting_war_exploded/startLogin.jsp");
    }
}
