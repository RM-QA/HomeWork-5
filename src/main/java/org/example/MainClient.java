package org.example;

public class MainClient {
    public static void main(String[] args) {
        Client client1 = new Client("Osama", 123, 12589623);
        Client client2 = new Client("Olga", 2000, 25859966);
        Client client3 = new Client("Daria", 90000, 2569856);

        Phone phone = new Phone(12, "samsung");
        phone.phoneMobileModel();
        phone.call();
    }
}
