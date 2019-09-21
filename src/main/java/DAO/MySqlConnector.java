package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private final static String DATABASENAME = "glosowanieCNBCh";
    private final static String USER = "root";
    private final static String PASSWORD = "root";

    private final static String URL =
            "jdbc:mysql://localhost:3306/" + DATABASENAME + "?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException ee){
            return null;
        }
    }
}
