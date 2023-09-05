package core.coder.Section16JDBC.repository;

import core.coder.Section16JDBC.domain.ConnectionJDBC;
import core.coder.Section16JDBC.domain.Person;
import core.coder.Section16JDBC.domain.PersonBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public static void insertPerson(String name) {
        String sql = "INSERT INTO person (name) VALUES (?);";

        try (Connection conn = ConnectionJDBC.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.execute();
            System.out.println("Person inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> findAllPerson() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM person;";
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int codeDB = resultSet.getInt("code");
                String nameDB = resultSet.getString("name");
                Person personDB = PersonBuilder.builder()
                        .code(codeDB)
                        .name(nameDB)
                        .build();
                personList.add(personDB);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    public static List<Person> findByCode(int code) {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE code = ?;";

        try (Connection conn = ConnectionJDBC.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codeDB = resultSet.getInt("code");
                String nameDB = resultSet.getString("name");
                Person personDB = PersonBuilder.builder()
                        .code(codeDB)
                        .name(nameDB)
                        .build();
                personList.add(personDB);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    public static List<Person> findByName(String name) {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE name = ?;";

        try (Connection conn = ConnectionJDBC.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, String.format(name, "%%%s%%"));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codeDB = resultSet.getInt("code");
                String nameDB = resultSet.getString("name");
                Person personDB = PersonBuilder.builder()
                        .code(codeDB)
                        .name(nameDB)
                        .build();
                personList.add(personDB);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    public static void updatePerson(Person person) {
        String select = "SELECT code, name FROM person WHERE code = ?";
        String update = "UPDATE person SET name = ? WHERE code = ?;";
        try (Connection conn = ConnectionJDBC.getConnection();
             PreparedStatement preparedStatementSelect = conn.prepareStatement(select)) {

            preparedStatementSelect.setInt(1, person.getCode());
            ResultSet result = preparedStatementSelect.executeQuery();
            result.next();
            System.out.println("Current person name is: " + result.getString("name"));

            PreparedStatement preparedStatementUpdate = conn.prepareStatement(update);
            preparedStatementUpdate.setString(1, person.getName());
            preparedStatementUpdate.setInt(2, person.getCode());
            preparedStatementUpdate.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
