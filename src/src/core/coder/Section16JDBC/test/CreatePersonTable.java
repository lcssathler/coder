package core.coder.Section16JDBC.test;

import core.coder.Section16JDBC.domain.ConnectionJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePersonTable {
    public static void main(String[] args) {
        String sql = """
                     CREATE TABLE IF NOT EXISTS person(
                     code INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(80) NOT NULL)
                     """;

        try(Connection connection = ConnectionJDBC.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
