package Servlets.user;

import DAO.Voting_DAO;
import Objects.Voting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/VotingsHistory")
public class VotingsHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Voting_DAO voting_dao=new Voting_DAO();
        List<Voting> votingsClosed=voting_dao.findAllClosed();
        request.setAttribute("votingsClosed", votingsClosed);
        getServletContext().getRequestDispatcher("/userVotingsHistory.jsp").forward(request, response);
    }
}
