package Num3;

import java.util.*;

public class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Геттеры
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Human other) {
        // Сравниваем по фамилии, затем по имени, затем по возрасту
        int lastNameCompare = this.lastName.compareTo(other.lastName);
        if (lastNameCompare != 0) return lastNameCompare;

        int firstNameCompare = this.firstName.compareTo(other.firstName);
        if (firstNameCompare != 0) return firstNameCompare;

        return Integer.compare(this.age, other.age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return age == human.age &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
}

