package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PytagoreanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
           arrayList.add(scanner.nextInt());
        }
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                for (int k = 0; k < arrayList.size(); k++) {
                   int firstNum = arrayList.get(i);
                    int secondNum = arrayList.get(j);
                    int thirdNum = arrayList.get(k);
                    if (firstNum * firstNum + secondNum * secondNum == thirdNum * thirdNum &&
                            firstNum <= secondNum){
                        System.out.printf("%d*%d + %d*%d = %d*%d",
                                firstNum,firstNum,
                                secondNum,secondNum,
                                thirdNum,thirdNum);
                        System.out.println();
                        count++;
                    }
                }
            }
        }
        if (count == 0){
            System.out.println("No");
        }
    }
}
