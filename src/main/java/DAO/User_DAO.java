package DAO;

import Objects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {

    Connection conn= MySqlConnector.createConnection();

    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String READ_USER_QUERY =
            "SELECT * FROM users where id = ?";
    private static final String READ_USER_EMAIL_QUERY =
            "SELECT * FROM users where email = ?";
    private static final String UPDATE_USER_OLD =
            "UPDATE users SET isNew=0 WHERE id = ?";
    private static final String INACTIVE_USER_QUERY =
            "UPDATE users SET isActive=0 WHERE id = ?";
    private static final String ACTIVE_USER_QUERY =
            "UPDATE users SET isActive=1 WHERE id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";
    private static final String FIND_ALL_ACTIVE_USERS =
            "SELECT * FROM users WHERE isActive=1";
    private static final String FIND_ALL_NEW_USERS_QUERY =
            "SELECT * FROM users WHERE isNew=1";
    private static final String FIND_ALL_OLD_USERS_QUERY =
            "SELECT * FROM users WHERE isNew=0";
    private static final String FIND_ALL_ADMIN_USERS =
            "SELECT * FROM users WHERE isAdmin=1";
    private static final String INACTIVE_USER_ADMIN_QUERY =
            "UPDATE users SET isAdmin=0 WHERE id = ?";
    private static final String ACTIVE_USER_ADMIN_QUERY =
            "UPDATE users SET isAdmin=1 WHERE id = ?";
    private static final String ALL_ACTIVE_USERS_ABLE_TO_MERGE_WITH_VOTING =
            "SELECT * FROM users LEFT JOIN results ON users.id = results.user_id WHERE users.isActive=1 AND voting_id !=? OR voting_id IS NULL;";


    public User create(User user) {
        User_DAO user_dao = new User_DAO();
        if (!user_dao.ifUserExists(user.getEmail())) {
        try {
                PreparedStatement statement =
                        conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                }
                return user;
            } catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public List<User> findAll() {
        try {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERS_QUERY);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setAdded(resultSet.getDate("added"));
            user.setNew(setBooleanValue(resultSet.getInt("isNew")));
            user.setActive(setBooleanValue(resultSet.getInt("isActive")));
            user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
            users.add(user);
        }
        return users;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

    public List<User> findAllNew() {
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_NEW_USERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdded(resultSet.getDate("added"));
                user.setNew(setBooleanValue(resultSet.getInt("isNew")));
                user.setActive(setBooleanValue(resultSet.getInt("isActive")));
                user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAllOld() {
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_OLD_USERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdded(resultSet.getDate("added"));
                user.setNew(setBooleanValue(resultSet.getInt("isNew")));
                user.setActive(setBooleanValue(resultSet.getInt("isActive")));
                user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAllActive() {
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_ACTIVE_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdded(resultSet.getDate("added"));
                user.setNew(setBooleanValue(resultSet.getInt("isNew")));
                user.setActive(setBooleanValue(resultSet.getInt("isActive")));
                user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAllActiveUsersAbleToMergeWithVoting(int voting_id) {
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(ALL_ACTIVE_USERS_ABLE_TO_MERGE_WITH_VOTING);
            statement.setInt(1, voting_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAllAdmin() {
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_ADMIN_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdded(resultSet.getDate("added"));
                user.setNew(setBooleanValue(resultSet.getInt("isNew")));
                user.setActive(setBooleanValue(resultSet.getInt("isActive")));
                user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {
        try {
            PreparedStatement statement = conn.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdded(resultSet.getDate("added"));
                user.setNew(setBooleanValue(resultSet.getInt("isNew")));
                user.setActive(setBooleanValue(resultSet.getInt("isActive")));
                user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User read(String email){
        try {
            PreparedStatement statement = conn.prepareStatement(READ_USER_EMAIL_QUERY);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdded(resultSet.getDate("added"));
                user.setNew(setBooleanValue(resultSet.getInt("isNew")));
                user.setActive(setBooleanValue(resultSet.getInt("isActive")));
                user.setAdmin(setBooleanValue(resultSet.getInt("isAdmin")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeStatus(int user_id) {
        if (isUserNotLastAdmin(user_id)) {
            try {
                User user = read(user_id);
                if (user.isNew()) {
                    PreparedStatement statement =
                            conn.prepareStatement(UPDATE_USER_OLD);
                    statement.setInt(1, user_id);
                    statement.executeUpdate();
                    return;
                }
                if (user.isActive()) {
                    PreparedStatement statement =
                            conn.prepareStatement(INACTIVE_USER_QUERY);
                    statement.setInt(1, user_id);
                    statement.executeUpdate();
                } else {
                    PreparedStatement statement =
                            conn.prepareStatement(ACTIVE_USER_QUERY);
                    statement.setInt(1, user_id);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException n) {
            }
        }
    }

    public void changeAdminStatus(int user_id) {
            try {
                User user = read(user_id);
                if (user.isAdmin()) {
                    if (isUserNotLastAdmin(user_id)) {
                        PreparedStatement statement =
                                conn.prepareStatement(INACTIVE_USER_ADMIN_QUERY);
                        statement.setInt(1, user_id);
                        statement.executeUpdate();
                    }
                } else {
                    PreparedStatement statement =
                            conn.prepareStatement(ACTIVE_USER_ADMIN_QUERY);
                    statement.setInt(1, user_id);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException n) {
            }
        }

    public void deleteUser(int user_id) {

        if (isUserNotLastAdmin(user_id)) {
            try {
                PreparedStatement statement =
                        conn.prepareStatement(DELETE_USER_QUERY);
                statement.setInt(1, user_id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean setBooleanValue(int value){
        if(value == 0){
            return false;
        }
        return true;
    }

    public boolean ifUserExists(String email){
        User_DAO user_dao=new User_DAO();
        User controlUser=user_dao.read(email);
        if (controlUser==null){
            return false;
        }
        return true;
    }

    private boolean isUserNotLastAdmin(int user_id){
        User user=read(user_id);
        if(user.isAdmin()) {
            List<User> allAdmin = findAllAdmin();
            if (allAdmin.size() == 1) {
                return false;
            }
        }
        return true;
    }
}
