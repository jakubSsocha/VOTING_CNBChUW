package Servlets.user;

import DAO.Result_DAO;
import DAO.User_DAO;
import DAO.Voting_DAO;
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
        HttpSession sess=request.getSession();
        int id=(int)sess.getAttribute("id");

        Result_DAO result_dao=new Result_DAO();
        Voting_DAO voting_dao=new Voting_DAO();

        List<Result> results=result_dao.findAllUserActive(id);
        List<Voting> votings=voting_dao.findAll();

        request.setAttribute("results", results);
        request.setAttribute("votings",votings);

        getServletContext().getRequestDispatcher("/userActiveVoting.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
