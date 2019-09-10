package Servlets.admin.all;

import DAO.Voting_DAO;
import Objects.Voting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allVotings")
public class allVotings extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Voting_DAO voting_dao=new Voting_DAO();
        List<Voting> votings=voting_dao.findAll();
        request.setAttribute("votings", votings);
        getServletContext().getRequestDispatcher("/VotingsMenu.jsp").forward(request, response);
    }
}
