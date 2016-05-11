package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamProblem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[\\s]+");
        int royalCount = 0;
        int nonRoyalCount = 0;
        ArrayList<String> royal = new ArrayList<>();
        ArrayList<String> nonRoyal = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            char[] array = input[i].toCharArray();
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j];
                while(sum >= 26){
                    sum -= 26;
                }
            }
            if (sum == 18){
                royalCount++;
                royal.add(input[i]);
            }else{
                nonRoyalCount++;
                nonRoyal.add(input[i]);
            }
        }
        if (royalCount >= nonRoyalCount){
            System.out.println("Royalists - " + royalCount);
            for (int i = 0; i < royal.size(); i++) {
                System.out.println(royal.get(i));
            }
            System.out.println("All hail Royal!");
        }else{
            for (int i = 0; i < nonRoyal.size(); i++) {
                System.out.println(nonRoyal.get(i));
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
