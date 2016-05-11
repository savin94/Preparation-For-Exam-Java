package com.company;

import java.util.Scanner;

public class TheBiggest3PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[()\\s]+");
        int maxSum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    if (input[i].equals("") || input[j].equals("") || input[k].equals("")){
                        continue;
                    }
                    int first = Integer.parseInt(input[i]);
                    int second = Integer.parseInt(input[j]);
                    int third = Integer.parseInt(input[k]);
                    int tempSum = first + second + third;
                    if (first % 2 != 0 &&
                            second % 2 != 0 &&
                            third % 2 != 0 &&
                            first > 1 && second > 1 &&
                            third > 1 &&
                            tempSum > maxSum){
                        i = j;
                        j = k;
                        k = k + 1;
                        maxSum = tempSum;
                    }
                }
            }
        }
        if (maxSum != 0){
            System.out.println(maxSum);
        }else{
            System.out.println("No");
        }
    }
}
