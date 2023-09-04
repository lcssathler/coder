package core.coder.Section16JDBC.service;

import core.coder.Section16JDBC.repository.PersonRepository;

import java.util.Scanner;

public class PersonService {
    public static void insertPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name to insert: ");
        String name = scanner.nextLine();

        PersonRepository.insertPerson(name);
    }
}
