package lotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection() {
        Connection connection = null;
        String server = "localhost";
        String database = "techcourse";
        String userName = "starkim06";
        String password = "201424415";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! JDBC DRIVER LOAD 오류" + e.getMessage());
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database
                    + "?useSSL=false&serverTimezone=UTC", userName, password);
            System.out.println("정상적으로 연결 되었습니다.");
        } catch (SQLException e) {
            System.out.println("연결 오류 : " + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("connection 오류 : " + e.getMessage());
        }
    }
}
