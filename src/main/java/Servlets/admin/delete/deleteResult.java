package Servlets.admin.delete;

import DAO.Result_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteResult")
public class deleteResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result_DAO result_dao=new Result_DAO();
        result_dao.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("http://localhost:8080/voting_war_exploded/admin/allResults");
    }
}
