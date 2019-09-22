package DAO;

import Objects.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Result_DAO {

    Connection conn= MySqlConnector.createConnection();

    private static final String CREATE_RESULT_QUERY =
            "INSERT INTO results(voting_id, user_id, vote, isActive) VALUES (?, ?, ?, 1)";
    private static final String READ_RESULT_QUERY =
            "SELECT * FROM results WHERE id = ?";
    private static final String READ_RESULT_QUERY_VOTING_USER =
            "SELECT * FROM results WHERE voting_id = ? AND user_id = ?";
    private static final String VOTE_RESULT_QUERY =
            "UPDATE results SET vote = ?, isActive=0, modified=CURRENT_TIMESTAMP WHERE id = ?";
    private static final String INACTIVE_RESULT_QUERY =
            "UPDATE results SET isActive=0 WHERE id = ?";
    private static final String ACTIVE_RESULT_QUERY =
            "UPDATE results SET isActive=1, vote=null, modified=null WHERE id = ?";
    private static final String FIND_ALL_RESULTS_QUERY =
            "SELECT * FROM results ORDER BY id ASC";
    private static final String FIND_ALL_RESULTS_BY_VOTING_ID_QUERY =
            "SELECT * FROM results WHERE voting_id=?";
    private static final String FIND_ALL_ACTIVE_RESULTS_USER =
            "SELECT * FROM results WHERE isAcrive=1 AND user_id = ? ORDER BY voting_id ASC";
    private static final String DELETE_RESULTS_QUERY =
            "DELETE FROM results WHERE id = ?";

    public List<Result> findAllAdmin() {
        try {
            List<Result> results = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_RESULTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result result=new Result();
                result.setId(resultSet.getInt("id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setVote(resultSet.getString("vote"));
                result.setActive(setBooleanValue(resultSet.getByte("isActive")));
                result.setCreated(resultSet.getDate("created"));
                result.setModified(resultSet.getDate("modified"));
                results.add(result);
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Result> findAllVotingId(int votingId) {
        try {
            List<Result> results = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_RESULTS_BY_VOTING_ID_QUERY);
            statement.setInt(1, votingId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result result=new Result();
                result.setId(resultSet.getInt("id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setVote(resultSet.getString("vote"));
                result.setActive(setBooleanValue(resultSet.getByte("isActive")));
                result.setCreated(resultSet.getDate("created"));
                result.setModified(resultSet.getDate("modified"));
                results.add(result);
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Result> findAllUserActive(int id) {
        try {
            List<Result> results = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_ACTIVE_RESULTS_USER);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Result result=new Result();
                result.setId(resultSet.getInt("id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setVote(resultSet.getString("vote"));
                result.setActive(setBooleanValue(resultSet.getByte("isActive")));
                result.setCreated(resultSet.getDate("created"));
                result.setModified(resultSet.getDate("modified"));
                results.add(result);
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Result create(Result result) {
        if (resultDoesNotExist(result.getVoting_id(), result.getUser_id())) {
            try {
                PreparedStatement statement =
                        conn.prepareStatement(CREATE_RESULT_QUERY, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, result.getVoting_id());
                statement.setInt(2, result.getUser_id());
                statement.setString(3, result.getVote());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    result.setId(resultSet.getInt(1));
                }
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void delete(int resultId) {
        Result result = read(resultId);
        if (result.getVote() == null) {
            try {
                PreparedStatement statement =
                        conn.prepareStatement(DELETE_RESULTS_QUERY);
                statement.setInt(1, resultId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void vote (String vote, int resultId){
        try {
            PreparedStatement statement =
                    conn.prepareStatement(VOTE_RESULT_QUERY);
            statement.setString(1, vote);
            statement.setInt(2, resultId);
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
                result.setId(resultSet.getInt("id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setVote(resultSet.getString("vote"));
                result.setActive(setBooleanValue(resultSet.getByte("isActive")));
                result.setCreated(resultSet.getDate("created"));
                result.setModified(resultSet.getDate("modified"));
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Result read(int votingId, int userId) {
        try {
            PreparedStatement statement = conn.prepareStatement(READ_RESULT_QUERY_VOTING_USER);
            statement.setInt(1, votingId);
            statement.setInt(2, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Result result=new Result();
                result.setId(resultSet.getInt("id"));
                result.setVoting_id(resultSet.getInt("voting_id"));
                result.setUser_id(resultSet.getInt("user_id"));
                result.setVote(resultSet.getString("vote"));
                result.setActive(setBooleanValue(resultSet.getByte("isActive")));
                result.setCreated(resultSet.getDate("created"));
                result.setModified(resultSet.getDate("modified"));
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
            if(result.isActive()){
                PreparedStatement statement =
                        conn.prepareStatement(INACTIVE_RESULT_QUERY);
                statement.setInt(1, resultId);
                statement.executeUpdate();
            } else{
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

    private boolean setBooleanValue(int value){
        if(value == 0){
            return false;
        }
        return true;
    }

    private boolean resultDoesNotExist(int voting_id, int user_id){
        Result result=read(voting_id,user_id);
        if (result == null){
            return true;
        }
        return false;
    }

}
