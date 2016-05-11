package com.company;

import java.util.Scanner;

public class Largest3Rectengles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] spliting = input.split("[\\[\\]\\sx]+\\s?+");
        int maxSum = 0;
        int count = 0;
        for (int i = 0; i < spliting.length; i++) {
            if (spliting[i].equals("")) {
                continue;
            }
            count++;
        }
        int[] array = new int[count];
        count = 0;
        for (int i = 0; i < spliting.length; i++) {
            if (spliting[i].equals("")) {
                count--;
                continue;

            }
            count++;
            array[count] = Integer.parseInt(spliting[i]);

        }
        for (int i = 0; i < array.length - 5; i++) {

            int tempSum = 0;
            tempSum += (array[i] * array[i + 1]) + (array[i+2] * array[i+3]) + (array[i+4] * array[i+5]);

            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        System.out.println(maxSum);
    }
}
