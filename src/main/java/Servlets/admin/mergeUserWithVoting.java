package Servlets.admin;

import DAO.User_DAO;
import DAO.Voting_DAO;
import Objects.User;
import Objects.Voting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mergeUserWithVoting")
public class mergeUserWithVoting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        User_DAO user_dao=new User_DAO();
        Voting_DAO voting_dao=new Voting_DAO();

        List<User> users=user_dao.findAllActiveUsersAbleToMergeWithVoting(id);
        Voting voting=voting_dao.read(id);

        request.setAttribute("voting",voting);
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/SelectUsersMenu.jsp").forward(request, response);
    }
}
