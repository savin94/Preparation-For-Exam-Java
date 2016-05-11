package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FireTheArrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer rowsCols = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowsCols][];

        for (int i = 0; i < rowsCols; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }
        boolean hasMoved = true;
        while (hasMoved) {
            hasMoved = false;

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {

                    int currentRow = row, currentCol = col;
                    char symbol = matrix[currentRow][currentCol];
                    if (symbol != 'o') {
                        int directRow = 0, directCol = 0,
                                nextRow, nextCol;

                        switch (symbol) {
                            case '^':
                                directRow = -1;
                                break;
                            case '>':
                                directCol = 1;
                                break;
                            case '<':
                                directCol = -1;
                                break;
                            case 'v':
                                directRow = 1;
                                break;
                            default:
                                break;
                        }

                        nextRow = directRow + currentRow;
                        nextCol = directCol + currentCol;

                        if (nextRow >= 0 && nextRow < matrix.length &&
                                nextCol >= 0 && nextCol < matrix[currentRow].length &&
                                matrix[nextRow][nextCol] == 'o') {

                            matrix[currentRow][currentCol] = 'o';
                            matrix[nextRow][nextCol] = symbol;
                            hasMoved = true;
                        }
                    }
                }
            }
        }
        Arrays.stream(matrix).forEach(s -> System.out.println(s));
    }
}