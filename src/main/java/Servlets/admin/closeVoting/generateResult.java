package Servlets.admin.closeVoting;

import DAO.Result_DAO;
import DAO.Voting_DAO;
import Objects.Result;
import Objects.Voting;
import Objects.VotingResults;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/generateResult")
public class generateResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int votingId = Integer.parseInt(request.getParameter("id"));
        Voting_DAO voting_dao = new Voting_DAO();
        Voting voting = voting_dao.read(votingId);
        request.setAttribute("voting", voting);

        VotingResults vR = new VotingResults(votingId);
        request.setAttribute("vR", vR);

        getServletContext().getRequestDispatcher("/DocumentVotingResult.jsp").forward(request, response);
    }
}
