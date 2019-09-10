package Servlets.closeVoting;

import DAO.Voting_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/closeVoting")
public class closeVoting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Voting_DAO voting_dao=new Voting_DAO();
        voting_dao.close(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("http://localhost:8080/voting_war_exploded/allVotings");
    }
}
