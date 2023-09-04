package core.coder.Section16JDBC.test;

import core.coder.Section16JDBC.domain.Person;
import core.coder.Section16JDBC.service.PersonService;

import java.util.List;

public class CrudTest01 {
    public static void main(String[] args) {
//        PersonService.insertPerson();

        List<Person> personList = PersonService.findAllPerson();
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
