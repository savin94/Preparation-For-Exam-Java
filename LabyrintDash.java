package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class LabyrintDash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int count = 0;
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
                char[] array = scanner.nextLine().toCharArray();
                matrix[i] = array;
            }
        char[] commands = scanner.nextLine().toCharArray();
        int directRow = 0, directCol = 0;
        int lives = 3;
        boolean isTrue = true;
        for (int i = 0; i < commands.length; i++) {
            if (lives <= 0){
                System.out.println("No lives left! Game Over!");
                System.out.println("Total moves made: " + count);
                isTrue = false;
                break;
            }
            int currenteow = directRow;
            int currentCol = directCol;
            switch (commands[i]) {
                case '^':
                    directRow += -1;
                    break;
                case '>':
                    directCol += 1;
                    break;
                case '<':
                    directCol += -1;
                    break;
                case 'v':
                    directRow += 1;
                    break;
                default:
                    break;
            }

           if (directCol < matrix[directRow].length && directCol >= 0 &&
                   directRow < matrix.length && directRow >= 0
                   && matrix[directRow][directCol] != ' ') {

               if (matrix[directRow][directCol] == '|' ||
                       matrix[directRow][directCol] == '_'){
                   directCol = currentCol;
                   directRow = currenteow;
                   System.out.println("Bumped a wall.");
               }
              else if (matrix[directRow][directCol] == '.' ){
                   System.out.println("Made a move!");
                   count++;
               }
               else if (matrix[directRow][directCol] == '#' ||
                       matrix[directRow][directCol] == '@' ||
                       matrix[directRow][directCol] == '*'){
                   lives--;
                   System.out.println("Ouch! That hurt! Lives left: " + lives);
                   count++;
                   if (lives <= 0){
                       System.out.println("No lives left! Game Over!");
                       System.out.println("Total moves made: " + count);
                       isTrue = false;
                       break;
                   }
               }
               else if (matrix[directRow][directCol] == '$'){
                   lives++;
                   System.out.println("Awesome! Lives left: " + lives);
                   matrix[directRow][directCol] = '.';
                   count++;
               }
           }else{
               System.out.println("Fell off a cliff! Game Over!");
               count++;
               System.out.println("Total moves made: " + count);
               isTrue = false;
               break;
           }
        }
        if (isTrue){
            System.out.println("Total moves made: " + count);
        }
    }
}
