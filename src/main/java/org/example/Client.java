package org.example;

public class Client {
    private String name;
    private int accountBalance;
    private int personalCode;

    public Client(String name, int accountBalance, int personalCode) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.personalCode = personalCode;

    }

    String greeting() {
        return "Tere";
    }

    int difference(int firest, int second) {
        return firest - second;
    }
}
