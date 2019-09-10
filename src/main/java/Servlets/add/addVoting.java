package Servlets.add;

import DAO.Voting_DAO;
import Objects.Voting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addVoting")
public class addVoting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("voting_title");
        String description=request.getParameter("voting_description");
        String status=request.getParameter("status");
        Voting voting=new Voting(title,description,status);
        Voting_DAO voting_dao=new Voting_DAO();
        voting_dao.create(voting);
        response.sendRedirect("http://localhost:8080/voting_war_exploded/allVotings");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
