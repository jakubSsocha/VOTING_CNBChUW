package Servlets.user;

import DAO.Result_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GenerateVote")
public class GenerateVote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vote=request.getParameter("vote");
        int result_id=Integer.parseInt(request.getParameter("id"));

        Result_DAO result_dao=new Result_DAO();

        result_dao.vote(vote,result_id);

        response.sendRedirect("http://localhost:8080/voting_war_exploded/UserResults");
    }
}
