package com.company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class TreeLargestNumers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        BigDecimal[] collectNumbers = new BigDecimal[inputLines];

        for (int i = 0; i < inputLines; i++) {
            collectNumbers[i] = new BigDecimal(scanner.nextLine());
        }
        Arrays.sort(collectNumbers);

        for (int i = collectNumbers.length; i > 0; i--) {
            System.out.println(collectNumbers[i-1].toPlainString());
            if (i == collectNumbers.length - 2){
                break;
            }
        }
    }
}
