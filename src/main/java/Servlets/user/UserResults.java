package Servlets.user;

import DAO.ActiveVotingsOfUserToVote_DAO;
import DAO.Result_DAO;
import DAO.User_DAO;
import DAO.Voting_DAO;
import Objects.ActiveVotingsOfUserToVote;
import Objects.Result;
import Objects.User;
import Objects.Voting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserResults")
public class UserResults extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess=request.getSession();
        int id=(int)sess.getAttribute("id");

        ActiveVotingsOfUserToVote_DAO activeVotingsOfUserToVote_dao=new ActiveVotingsOfUserToVote_DAO();

        List<ActiveVotingsOfUserToVote> activeResultsList=activeVotingsOfUserToVote_dao.findAll(id);
        request.setAttribute("activeResults", activeResultsList);

        getServletContext().getRequestDispatcher("/userActiveVoting.jsp").forward(request, response);
    }
}
