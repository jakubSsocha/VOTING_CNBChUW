package Servlets.user;

import DAO.User_DAO;
import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateNewUser")
public class CreateNewUser extends HttpServlet {

    private final String userAlreadyExist = "Użytkownik o podanym adresie jest już zarejestrowany!";
    private final String newUserAccountCreated = "Użytkownik dodany pomyślnie. Poczekaj na akceptację konta przez administratora!";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User_DAO user_dao=new User_DAO();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        if(user_dao.ifUserExists(email)){
            request.setAttribute("text",userAlreadyExist);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        String password=request.getParameter("password");
        User user=new User(name,email,password);
        user_dao.create(user);
        request.setAttribute("text",newUserAccountCreated);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://localhost:8080/voting_war_exploded/startCreateNewUser.jsp");
    }
}
