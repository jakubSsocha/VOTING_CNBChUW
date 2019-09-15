package DAO;

import Objects.Voting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Voting_DAO {

    Connection conn = MySqlConnector.createConnection();

    private static final String CREATE_VOTING_QUERY =
            "INSERT INTO votings(title, description) VALUES (?, ?)";
    private static final String READ_VOTING_QUERY =
            "SELECT * FROM votings where id = ?";
    private static final String UPDATE_VOTING_OLD =
            "UPDATE votings SET isNew=0 WHERE id = ?";
    private static final String UPDATE_VOTING_QUERY =
            "UPDATE votings SET voting_title = ?, voting_description = ?, status = ? where voting_id = ?";
    private static final String INACTIVE_VOTING_QUERY =
            "UPDATE votings SET isActive=0 WHERE id = ?";
    private static final String ACTIVE_VOTING_QUERY =
            "UPDATE votings SET isActive=1 WHERE id = ?";
    private static final String DELETE_VOTING_QUERY =
            "DELETE FROM votings WHERE id = ?";
    private static final String FIND_ALL_VOTING_QUERY =
            "SELECT * FROM votings";
    private static final String FIND_ALL_NEW_VOTING_QUERY =
            "SELECT * FROM votings WHERE isNew=1";
    private static final String FIND_ALL_OLD_VOTING_QUERY =
            "SELECT * FROM votings WHERE isNew=0 AND isClosed=0";
    private static final String FIND_ALL_CLOSED_VOTING_QUERY =
            "SELECT * FROM votings WHERE isClosed=1";
    private static final String FIND_ALL_ACTIVE_VOTING_QUERY =
            "SELECT * FROM votings WHERE isActive=1";
    private static final String CLOSE_VOTING_QUERY =
            "UPDATE votings SET isActive=0, closed =CURRENT_TIMESTAMP, isClosed=1 WHERE id = ?";

    public Voting create(Voting voting) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_VOTING_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, voting.getTitle());
            statement.setString(2, voting.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                voting.setId(resultSet.getInt(1));
            }
            return voting;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voting> findAllNew() {
        try {
            List<Voting> votings = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_NEW_VOTING_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Voting voting = new Voting();
                voting.setId(resultSet.getInt("id"));
                voting.setTitle(resultSet.getString("title"));
                voting.setDescription(resultSet.getString("description"));
                voting.setCreated(resultSet.getDate("created"));
                voting.setClosedDate(resultSet.getDate("closed"));
                voting.setNew(setBooleanValue(resultSet.getByte("isNew")));
                voting.setActive(setBooleanValue(resultSet.getByte("isActive")));
                voting.setClosed(setBooleanValue(resultSet.getByte("isClosed")));
                votings.add(voting);
            }
            return votings;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voting> findAllOld() {
        try {
            List<Voting> votings = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_OLD_VOTING_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Voting voting = new Voting();
                voting.setId(resultSet.getInt("id"));
                voting.setTitle(resultSet.getString("title"));
                voting.setDescription(resultSet.getString("description"));
                voting.setCreated(resultSet.getDate("created"));
                voting.setClosedDate(resultSet.getDate("closed"));
                voting.setNew(setBooleanValue(resultSet.getByte("isNew")));
                voting.setActive(setBooleanValue(resultSet.getByte("isActive")));
                voting.setClosed(setBooleanValue(resultSet.getByte("isClosed")));
                votings.add(voting);
            }
            return votings;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voting> findAllClosed() {
        try {
            List<Voting> votings = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_CLOSED_VOTING_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Voting voting = new Voting();
                voting.setId(resultSet.getInt("id"));
                voting.setTitle(resultSet.getString("title"));
                voting.setDescription(resultSet.getString("description"));
                voting.setCreated(resultSet.getDate("created"));
                voting.setClosedDate(resultSet.getDate("closed"));
                voting.setNew(setBooleanValue(resultSet.getByte("isNew")));
                voting.setActive(setBooleanValue(resultSet.getByte("isActive")));
                voting.setClosed(setBooleanValue(resultSet.getByte("isClosed")));
                votings.add(voting);
            }
            return votings;
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
                voting.setId(resultSet.getInt("id"));
                voting.setTitle(resultSet.getString("title"));
                voting.setDescription(resultSet.getString("description"));
                voting.setCreated(resultSet.getDate("created"));
                voting.setClosedDate(resultSet.getDate("closed"));
                voting.setNew(setBooleanValue(resultSet.getByte("isNew")));
                voting.setActive(setBooleanValue(resultSet.getByte("isActive")));
                voting.setClosed(setBooleanValue(resultSet.getByte("isClosed")));
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
                Voting voting = new Voting();
                voting.setId(resultSet.getInt("id"));
                voting.setTitle(resultSet.getString("title"));
                voting.setDescription(resultSet.getString("description"));
                voting.setCreated(resultSet.getDate("created"));
                voting.setClosedDate(resultSet.getDate("closed"));
                voting.setNew(setBooleanValue(resultSet.getByte("isNew")));
                voting.setActive(setBooleanValue(resultSet.getByte("isActive")));
                voting.setClosed(setBooleanValue(resultSet.getByte("isClosed")));
                return voting;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeStatus(int votingId) {
        Voting voting = read(votingId);
        if (!voting.isClosed()) {
            try {
                if (voting.isNew()) {
                    PreparedStatement statement =
                            conn.prepareStatement(UPDATE_VOTING_OLD);
                    statement.setInt(1, votingId);
                    statement.executeUpdate();
                    return;
                }
                if (voting.isActive()) {
                    PreparedStatement statement =
                            conn.prepareStatement(INACTIVE_VOTING_QUERY);
                    statement.setInt(1, votingId);
                    statement.executeUpdate();
                } else {
                    PreparedStatement statement =
                            conn.prepareStatement(ACTIVE_VOTING_QUERY);
                    statement.setInt(1, votingId);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException n) {

            }
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
        Voting voting = read(votingId);
        if (!voting.isClosed()) {
            try {
                PreparedStatement statement =
                        conn.prepareStatement(CLOSE_VOTING_QUERY);
                statement.setInt(1, votingId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException n) {

            }
        }
    }

    private boolean setBooleanValue(int value){
        if(value == 0){
            return false;
        }
        return true;
    }
}
