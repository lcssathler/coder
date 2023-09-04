package core.coder.Section16JDBC.test;

import core.coder.Section16JDBC.domain.ConnectionJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        try(Connection connection = ConnectionJDBC.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS java_coder");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
