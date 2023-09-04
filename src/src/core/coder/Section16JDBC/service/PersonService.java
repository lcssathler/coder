package core.coder.Section16JDBC.service;

import core.coder.Section16JDBC.domain.Person;
import core.coder.Section16JDBC.repository.PersonRepository;

import java.util.List;
import java.util.Scanner;

public class PersonService {
    public static void insertPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name to insert: ");
        String name = scanner.nextLine();

        PersonRepository.insertPerson(name);
    }

    public static List<Person> findAllPerson() {
        return PersonRepository.findAllPerson();
    }
}
