package org.example;

public class Arrays {
    public static void main(String[] args) {
        // 1.1
        int[] newArrays;
        newArrays = new int[5];
        newArrays[0] = 5;
        for (int number = 0; number < newArrays.length; number++) {
            System.out.println(newArrays[number]);
        }
        // 1.2
        String[] names;
        names = new String[5];
        names[2] = "jujo";
        for (int newName = 0; newName < names.length; newName++) {
            System.out.println(names[newName]);
        }

        // 2
        String str = "To be or not to be";
        char[] charArray = str.toCharArray();
        char char1 = 'o';
        int count = 0;
        for (int index = 0; index < charArray.length; index++) {
            if (charArray[index] == char1) {
                System.out.println("for-loop: The characters are equal at " + index);
                count++;
            } else {
                System.out.println("for-loop: The characters are not equal at " + index);
            }
        }
        System.out.println("for-loop: Count is " + count);
        int index = 0;
        char1 = 'e';
        count = 0;
        while (index < charArray.length) {
            if (charArray[index] == char1) {
                System.out.println("while-loop: The characters are equal at " + index);
                count++;
            } else {
                System.out.println("while-loop: The characters are not equal at " + index);
            }
            index++;
        }
        System.out.println("while-loop: Count is " + count);

        // optional (3)
        int[] numbers1 = {5, 42, 15, 6, 17, 37, 9};
        double sum = 0;
        for (int i = 0; i < numbers1.length; i++) {
            sum = sum + numbers1[i];
        }
        double mean = sum / numbers1.length;
        System.out.println("arithmetic mean is " + mean);


        // optional (4)
        int numbers[] = {12, 13, 1, 10, 34, 10};
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        System.out.print(max);
    }
}