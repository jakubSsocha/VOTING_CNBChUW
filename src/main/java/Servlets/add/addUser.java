package Servlets.add;

import DAO.User_DAO;
import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class addUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("user_username");
        String email=request.getParameter("user_email");
        String password=request.getParameter("user_password");
        String status=request.getParameter("status");
        User user=new User(name,email,password,status);
        User_DAO user_dao=new User_DAO();
        user_dao.create(user);
        response.sendRedirect("http://localhost:8080/voting_war_exploded/allUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
