package core.coder.Section16JDBC.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/java_coder?verifyServerCertificate=false&useSSL=true";
        String user = "root";
        String password = "root";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
