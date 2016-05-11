package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String first = scanner.nextLine().trim();
        int firstNumber = Integer.parseInt(first);
        String output = "" + firstNumber;


        for (int row = 0; row < rows - 1; row++) {
            String[] numbersAsStrings = scanner.nextLine().split("[\\s]+");
            int matrixSize = numbersAsStrings.length;
            for (int i = 0; i < numbersAsStrings.length; i++) {
             if (numbersAsStrings[i].equals("")){
                 matrixSize--;
             }
            }
            int[] numbers = new int[matrixSize];
            int count = 0;
            for (int col = numbersAsStrings.length - matrixSize; col < numbersAsStrings.length; col++) {
                numbers[count] = Integer.parseInt(numbersAsStrings[col]);
                count++;
            }
            Arrays.sort(numbers);
            boolean isBreak = false;
            for (int i = 0; i < numbers.length; i++) {
                int current = numbers[i];
                if (current > firstNumber){
                    firstNumber = current;
                    isBreak = true;
                    output += ", " + firstNumber;
                    break;
                }
            }
            if (!isBreak){
                firstNumber++;
            }
        }
        System.out.println(output);
    }
}
