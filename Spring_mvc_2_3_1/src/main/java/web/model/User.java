package web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String sekondName;

    @Column
    private int age;

    public User() {
    }

    public User(String name, String sekondName, int age) {
        this.name = name;
        this.sekondName = sekondName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSekondName() {
        return sekondName;
    }

    public void setSekondName(String surname) {
        this.sekondName = sekondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + sekondName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof User other) {
            return other.name.equals(name)
                    && other.sekondName.equals(sekondName)
                    && other.age == (age);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sekondName, age);
    }
}