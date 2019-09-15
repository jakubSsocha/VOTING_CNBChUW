package Servlets.admin.closeVoting;

import DAO.Result_DAO;
import Objects.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createResult")
public class createResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("voting_id"));
        String[] users_id=request.getParameterValues("added");
        int user_id_int=0;
        Result_DAO result_dao=new Result_DAO();
        for(int i=0; i<users_id.length;i++){
            user_id_int=Integer.parseInt(users_id[i]);
            Result result=new Result(id,user_id_int);
            result_dao.create(result);
        }
        response.sendRedirect("http://localhost:8080/voting_war_exploded/allResults");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
