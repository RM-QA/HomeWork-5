package org.example;


import java.util.Scanner;

public class Phone {
    private int number;
    private String model;
    private float weight;

    public Phone(int number, String model, float weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public void phoneMobileModel() {
        System.out.println(model);
    }

    public void call() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Calling: " + number);
    }
}
