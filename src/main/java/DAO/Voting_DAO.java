package DAO;

import Objects.Voting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Voting_DAO {

    Connection conn= MySqlConnector.createConnection();

    private static final String CREATE_VOTING_QUERY =
            "INSERT INTO votings(voting_title, voting_description, status) VALUES (?, ?, ?)";
    private static final String READ_VOTING_QUERY =
            "SELECT * FROM votings where voting_id = ?";
    private static final String UPDATE_VOTING_QUERY =
            "UPDATE votings SET voting_title = ?, voting_description = ?, status = ? where voting_id = ?";
    private static final String INACTIVE_VOTING_QUERY =
            "UPDATE votings SET status=\"inactive\" WHERE voting_id = ?";
    private static final String ACTIVE_VOTING_QUERY =
            "UPDATE votings SET status=\"active\" WHERE voting_id = ?";
    private static final String DELETE_VOTING_QUERY =
            "DELETE FROM votings WHERE voting_id = ?";
    private static final String FIND_ALL_VOTING_QUERY =
            "SELECT * FROM votings";
    private static final String FIND_ALL_VOTING_USERS =
            "SELECT * FROM votings WHERE status = active";
    private static final String CLOSE_VOTING_QUERY=
            "UPDATE votings SET status=\"closed\" WHERE voting_id = ?";

    public Voting create(Voting voting) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_VOTING_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, voting.getTitle());
            statement.setString(2, voting.getDescription());
            statement.setString(3, voting.get);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                voting.setVoting_id(resultSet.getInt(1));
            }
            return voting;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voting> findAll() {
        try {
            List<Voting> votings = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_VOTING_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Voting voting = new Voting();
                voting.setVoting_id(resultSet.getInt("voting_id"));
                voting.setVoting_title(resultSet.getString("voting_title"));
                voting.setVoting_description(resultSet.getString("voting_description"));
                voting.setVoting_status(resultSet.getString("status"));
                votings.add(voting);
            }
            return votings;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Voting read(int votingId) {
        try {
            PreparedStatement statement = conn.prepareStatement(READ_VOTING_QUERY);
            statement.setInt(1, votingId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Voting voting=new Voting();
                voting.setVoting_id(resultSet.getInt("voting_id"));
                voting.setVoting_title(resultSet.getString("voting_title"));
                voting.setVoting_description(resultSet.getString("voting_description"));
                voting.setVoting_status(resultSet.getString("status"));
                return voting;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeStatus(int votingId) {
        try {
            Voting voting=read(votingId);
            if(voting.getVoting_status().equals("active")){
                PreparedStatement statement =
                        conn.prepareStatement(INACTIVE_VOTING_QUERY);
                statement.setInt(1, votingId);
                statement.executeUpdate();
            } else if (voting.getVoting_status().equals("inactive")){
                PreparedStatement statement =
                        conn.prepareStatement(ACTIVE_VOTING_QUERY);
                statement.setInt(1, votingId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n){

        }
    }

    public void deleteVoting(int votingId){
        try {
            PreparedStatement statement =
                    conn.prepareStatement(DELETE_VOTING_QUERY);
            statement.setInt(1, votingId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(int votingId) {
        try {
            Voting voting=read(votingId);
                PreparedStatement statement =
                        conn.prepareStatement(CLOSE_VOTING_QUERY);
                statement.setInt(1, votingId);
                statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n){

        }
    }
}
