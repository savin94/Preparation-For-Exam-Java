package com.company;

import java.util.Scanner;

public class LongestOddEvenSequance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[ ()]+");
        int size = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("")){
                continue;
            }
            size++;
        }
        int[] nums = new int[size];
        int matrixPleace = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i].equals("")){
                continue;
            }
            nums[matrixPleace] = Integer.parseInt(input[i]);
            matrixPleace++;
        }
        boolean shouldBeOdd = (nums[0] % 2 != 0);
        int bestCount = 0;
        int count = 0;
        for (int num : nums) {
            boolean isOdd = num % 2 != 0;
            if (isOdd == shouldBeOdd || num == 0){
                count++;
            }else{
                shouldBeOdd = isOdd;
                count = 1;
            }
            shouldBeOdd = !shouldBeOdd;
            if (count > bestCount){
                bestCount = count;
            }
        }
        System.out.println(bestCount);
    }
}
