package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int devider = scanner.nextInt();

        String num = scanner.nextLine();
        ArrayList<Integer> numList = new ArrayList<>();

        while (!num.equals("End")) {
            if (num.equals("")) {
                num = scanner.nextLine();
            } else {
                int newNum = Integer.parseInt(num);
                numList.add(newNum);
                num = scanner.nextLine();
            }
        }
        int maxSum = -2000000;
        int firsNum = 0;
        int secondNum = 0;
        int thirdNum = 0;
        int count = 0;
        for (int i = 0; i < numList.size(); i++) {
            for (int j = i + 1; j < numList.size(); j++) {
                for (int k = j + 1; k < numList.size(); k++) {
                    int tempSum = 0;
                    int first = numList.get(i);
                    int second = numList.get(j);
                    int third = numList.get(k);
                    tempSum = first + second + third;

                    if (tempSum > maxSum && tempSum % devider == 0) {

                            firsNum = first;
                            secondNum = second;
                            thirdNum = third;
                            maxSum = tempSum;
                            count++;
                        }
                }
            }
        }
                if (count != 0) {
                    System.out.println("(" + firsNum +
                            " + " + secondNum + " + "
                            + thirdNum + ")" + " % " + devider
                            + " = " + 0);
                } else {
                    System.out.println("No");
                }

    }
}