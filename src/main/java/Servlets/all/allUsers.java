package Servlets.all;

import DAO.User_DAO;
import Objects.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allUsers")
public class allUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User_DAO user_dao=new User_DAO();
        List<User> users=user_dao.findAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/UsersMenu.jsp").forward(request, response);
    }
}
