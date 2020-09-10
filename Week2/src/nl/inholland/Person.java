package nl.inholland;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private static int nextId = 1;
    protected int id;
    protected String firstName;
    protected String lastName;
    protected LocalDate birthdate;
    protected String username;
    private String password;
    protected LevelOfAccess levelOfAccess;

    public Person(String firstName, String lastName, LocalDate birthdate, String username, String password) {
        this.id = nextId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.username = username;
        this.password = password;
        nextId++;
    }

    public Person(int id, String firstName, String lastName, LocalDate birthdate, String username, String password) {
        this(firstName, lastName, birthdate, username, password);
        this.id = id;
        nextId = id+1;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Person " + firstName + " " + lastName;
    }
}
