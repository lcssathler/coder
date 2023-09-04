package core.coder.Section16JDBC.domain;

public class Person {
    private int code;
    private String name;

    public Person(int code, String name) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
