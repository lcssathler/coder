package core.coder.Section16JDBC.domain;

public final class PersonBuilder {
    private int code;
    private String name;

    private PersonBuilder() {
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder code(int code) {
        this.code = code;
        return this;
    }

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Person build() {
        return new Person(code, name);
    }
}
