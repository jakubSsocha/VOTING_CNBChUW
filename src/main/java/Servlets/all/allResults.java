package Servlets.all;

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
import java.io.IOException;
import java.util.List;

@WebServlet("/allResults")
public class allResults extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result_DAO result_dao=new Result_DAO();
        User_DAO user_dao=new User_DAO();
        Voting_DAO voting_dao=new Voting_DAO();

        List<Result> results=result_dao.findAllAdmin();
        List<User> users=user_dao.findAll();
        List<Voting> votings=voting_dao.findAll();

        request.setAttribute("results", results);
        request.setAttribute("users",users);
        request.setAttribute("votings",votings);

        getServletContext().getRequestDispatcher("/ResultsMenu.jsp").forward(request, response);
    }
}
