package org.example;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void celebrateBirthday() {
        this.age++;
    }

    void changeName(String newName) {
        this.name = newName;
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }
}