package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    void testChangeAgeSuccessful() {
        Person person = new Person("Bob", 25);
        person.changeName("Mart");

        Assertions.assertEquals("Mart", person.getName());
    }

    @Test
    void testCelebrateBirthday() {
        Person person = new Person("Charlie", 35);
        person.celebrateBirthday();

        Assertions.assertEquals(36, person.getAge());
    }
}
