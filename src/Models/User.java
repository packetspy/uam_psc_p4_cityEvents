package Models;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private LocalDate birthday;
    private int age;
    private String gender;
    private String password;

    public User(String name, String email, LocalDate birthday, String gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = Period.between(this.birthday, LocalDate.now()).getYears();
        this.gender = gender;
    }

    public User(String name, String email, LocalDate birthday, String gender, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = Period.between(this.birthday, LocalDate.now()).getYears();
        this.gender = gender;
        this.password = password;
    }

    public User(UUID id, String name, String email, LocalDate birthday, String gender, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = Period.between(this.birthday, LocalDate.now()).getYears();
        this.gender = gender;
        this.password = password;
    }

    public User() {
        this.id = null;
        this.name = null;
        this.email = null;
        this.birthday = null;
        this.age = 0;
        this.gender = null;
        this.password = null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + birthday + "," + gender + "," + password;
    }

    public String toShowList() {
        return name + " \t\t " + email + " \t\t " + gender + " \t\t " + birthday + " (" + age + " anos)";
    }
}