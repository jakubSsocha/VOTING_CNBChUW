package Servlets.admin.delete;

import DAO.User_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User_DAO user_dao=new User_DAO();
        System.out.println(request.getParameter("id"));
        user_dao.deleteUser(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("http://localhost:8080/voting_war_exploded/allUsers");
    }
}
