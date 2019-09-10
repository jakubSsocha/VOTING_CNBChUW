package DAO;

import Objects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {

    Connection conn= MySqlConnector.createConnection();

    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(user_username, user_email, user_password, status, admin_status) VALUES (?, ?, ?,?,?)";
    private static final String READ_USER_QUERY =
            "SELECT * FROM users where user_id = ?";
    private static final String READ_USER_EMAIL_QUERY =
            "SELECT * FROM users where user_email = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET user_username = ?, user_email = ?, user_password = ? where user_id = ?";
    private static final String INACTIVE_USER_QUERY =
            "UPDATE users SET status=\"inactive\" WHERE user_id = ?";
    private static final String ACTIVE_USER_QUERY =
            "UPDATE users SET status=\"active\" WHERE user_id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE user_id = ?";
    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";
    private static final String FIND_ALL_ACTIVE_USERS =
            "SELECT * FROM users WHERE status = \"active\"";

    public User create(User user) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUser_username());
            statement.setString(2, user.getUser_email());
            statement.setString(3, user.getUser_password());
            statement.setString(4,user.getStatus());
            statement.setString(5,user.getAdmin_status());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setUser_id(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAll() {
        try {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERS_QUERY);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setUser_id(resultSet.getInt("user_id"));
            user.setUser_username(resultSet.getString("user_username"));
            user.setUser_email(resultSet.getString("user_email"));
            user.setStatus(resultSet.getString("status"));
            user.setUser_password(resultSet.getString("user_password"));
            user.setAdmin_status(resultSet.getString("admin_status"));
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
                user.setUser_id(resultSet.getInt("user_id"));
                user.setUser_username(resultSet.getString("user_username"));
                user.setUser_email(resultSet.getString("user_email"));
                user.setUser_password(resultSet.getString("user_password"));
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
                user.setUser_id(resultSet.getInt("user_id"));
                user.setUser_username(resultSet.getString("user_username"));
                user.setUser_email(resultSet.getString("user_email"));
                user.setUser_password(resultSet.getString("user_password"));
                user.setStatus(resultSet.getString("status"));
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
                user.setUser_id(resultSet.getInt("user_id"));
                user.setUser_username(resultSet.getString("user_username"));
                user.setUser_email(resultSet.getString("user_email"));
                user.setUser_password(resultSet.getString("user_password"));
                user.setStatus(resultSet.getString("status"));
                user.setAdmin_status(resultSet.getString("admin_status"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeStatus(int user_id) {
        try {
            User user=read(user_id);
            if(user.getStatus().equals("active")){
                PreparedStatement statement =
                        conn.prepareStatement(INACTIVE_USER_QUERY);
                statement.setInt(1, user_id);
                statement.executeUpdate();
            } else if (user.getStatus().equals("inactive")){
                PreparedStatement statement =
                        conn.prepareStatement(ACTIVE_USER_QUERY);
                statement.setInt(1, user_id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n){

        }
    }

    public void deleteUser(int user_id){
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
