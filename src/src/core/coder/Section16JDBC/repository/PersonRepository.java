package core.coder.Section16JDBC.repository;

import core.coder.Section16JDBC.domain.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonRepository {
    public static void insertPerson(String name) {
        String sql = "INSERT INTO person (name) VALUES (?);";

        try(Connection conn = ConnectionJDBC.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.execute();
            System.out.println("Person inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
