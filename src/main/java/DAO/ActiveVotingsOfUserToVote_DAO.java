package DAO;

import Objects.ActiveVotingsOfUserToVote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActiveVotingsOfUserToVote_DAO {

    Connection conn= MySqlConnector.createConnection();

    private final String FIND_ALL_ACTIVE_USER_VOTINGS_QUERY =
            "SELECT * FROM results JOIN votings ON results.voting_id = votings.id WHERE user_id= ? AND votings.isActive=1 AND results.isActive=1";

    public List<ActiveVotingsOfUserToVote> findAll(int user_id) {
        try {
            List<ActiveVotingsOfUserToVote> activeVotingsOfUserToVoteArrayList = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_ACTIVE_USER_VOTINGS_QUERY);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ActiveVotingsOfUserToVote activeVotingsOfUserToVote = new ActiveVotingsOfUserToVote();
                activeVotingsOfUserToVote.setId(resultSet.getInt("results.id"));
                activeVotingsOfUserToVote.setCreated(resultSet.getDate("votings.created"));
                activeVotingsOfUserToVote.setTitle(resultSet.getString("votings.title"));
                activeVotingsOfUserToVote.setDescription(resultSet.getString("votings.description"));
                activeVotingsOfUserToVote.setVote(resultSet.getString("results.vote"));
                activeVotingsOfUserToVoteArrayList.add(activeVotingsOfUserToVote);
            }
            return activeVotingsOfUserToVoteArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
