package DAO;

import Objects.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Result_DAO {

    Connection conn= MySqlConnector.createConnection();

    private static final String CREATE_RESULT_QUERY =
            "INSERT INTO results(voting_id, user_id, result_vote, status) VALUES (?, ?, ?, ?)";
    private static final String READ_RESULT_QUERY =
            "SELECT * FROM results WHERE result_id = ?";
    private static final String UPDATE_RESULT_QUERY =
            "UPDATE results SET result_vote = ? status = ? WHERE user_id = ? AND status = \"active\" ";
    private static final String INACTIVE_RESULT_QUERY =
            "UPDATE results SET status=\"inactive\" WHERE result_id = ?";
    private static final String ACTIVE_RESULT_QUERY =
            "UPDATE results SET status=\"active\" WHERE result_id = ?";
    private static final String FIND_ALL_RESULTS_QUERY =
            "SELECT * FROM results ORDER BY voting_id ASC";
    private static final String FIND_ALL_ACTIVE_RESULTS =
            "SELECT * FROM results WHERE status = active";
    private static final String DELETE_RESULTS_QUERY =
            "DELETE FROM results WHERE result_id = ?";

    public List<Result> findAllAdmin() {
        try {
            List<Result> results = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_RESULTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result result=new Result();
                result.setResult_id(resultSet.getInt("result_id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setResult_vote(resultSet.getString("result_vote"));
                result.setStatus(resultSet.getString("status"));
                results.add(result);
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Result create(Result result) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_RESULT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, result.getVoting_id());
            statement.setInt(2, result.getUser_id());
            statement.setString(3, result.getResult_vote());
            statement.setString(4,result.getStatus());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result.setResult_id(resultSet.getInt(1));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(int resultId){
        try {
            PreparedStatement statement =
                    conn.prepareStatement(DELETE_RESULTS_QUERY);
            statement.setInt(1, resultId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Result read(int resultId) {
        try {
            PreparedStatement statement = conn.prepareStatement(READ_RESULT_QUERY);
            statement.setInt(1, resultId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Result result=new Result();
                result.setResult_id(resultSet.getInt("result_id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setResult_vote(resultSet.getString("result_vote"));
                result.setStatus(resultSet.getString("status"));
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeStatus(int resultId) {
        try {
            Result result=read(resultId);
            if(result.getStatus().equals("active")){
                PreparedStatement statement =
                        conn.prepareStatement(INACTIVE_RESULT_QUERY);
                statement.setInt(1, resultId);
                statement.executeUpdate();
            } else if (result.getStatus().equals("inactive")){
                PreparedStatement statement =
                        conn.prepareStatement(ACTIVE_RESULT_QUERY);
                statement.setInt(1, resultId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n){

        }
    }

}
