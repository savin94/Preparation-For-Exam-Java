package com.company;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.portable.Streamable;

import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("[\\s]+");
        int rows = Integer.parseInt(nums[0]);
        int cols = Integer.parseInt(nums[0]);
        String[][] matrix = new String[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count++;
                String temp = String.valueOf(count);
                matrix[i][j] = temp;
            }
        }
        String[] command = scanner.nextLine().split("[\\s]+");
        while(!command[0].equals("Nuke")){
            int row = Integer.parseInt(command[0]);
            int col = Integer.parseInt(command[1]);
            int moves = Integer.parseInt(command[2]);

            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length){
                matrix[row][col] = "";
                for (int i = 0; i < 4; i++) {
                    int newRow = row;
                    int newCol = col;
                    for (int j = 0; j < moves; j++) {
                        switch(i){
                            case 0:
                                newRow--;
                                if (newRow >=0 && newRow < matrix.length && matrix[newRow][newCol].equals("")){
                                    newRow--;
                                }
                                break;
                            case 1:
                                newRow++;
                                if (newRow >=0 && newRow < matrix.length && matrix[newRow][newCol].equals("")){
                                    newRow++;
                                }
                                break;
                            case 2:
                                newCol--;
                                if (newCol >=0 && newCol < matrix.length &&matrix[newRow][newCol].equals("")){
                                    newCol--;
                                }
                                break;
                            case 3:
                                newCol++;
                                if (newCol >=0 && newCol < matrix.length && matrix[newRow][newCol].equals("")){
                                    newCol++;
                                }
                        }
                        if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.length){
                            matrix[newRow][newCol] = "";
                        }
                    }
                }
            }
            command = scanner.nextLine().split("[\\s]+");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("")){
                    continue;
                }
                System.out.print(matrix[i][j]);
                if (j < matrix.length){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
