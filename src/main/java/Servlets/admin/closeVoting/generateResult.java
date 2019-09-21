package Servlets.admin.closeVoting;

import DAO.Result_DAO;
import DAO.Voting_DAO;
import Objects.Result;
import Objects.Voting;

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

        Result_DAO result_dao = new Result_DAO();
        List<Result> resultList = result_dao.findAllVotingId(votingId);
        int TAK = 0;
        int NIE = 0;
        int WST = 0;
        for (Result r : resultList) {
            if (r.getVote() == null) {

            } else {
                if (r.getVote().equals("TAK")) {
                    TAK++;
                }
                if (r.getVote().equals("NIE")) {
                    NIE++;
                }
                if (r.getVote().equals("WST")) {
                    WST++;
                }
            }
        }
        request.setAttribute("TAK", TAK);
        request.setAttribute("NIE", NIE);
        request.setAttribute("WST", WST);

        getServletContext().

                getRequestDispatcher("/DocumentVotingResult.jsp").

                forward(request, response);
    }
}
