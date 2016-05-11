package com.company;

import java.util.Scanner;

public class CollectResourses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[ ]+");
        int lines = Integer.parseInt(scanner.nextLine());
        String chechValid = "stonegoldwoodfood";
        String checkIfCollectet = "";
        int maxResult = 0;
        for (int i = 0; i < lines; i++) {
            String[] startEnd = scanner.nextLine().split("[ ]+");
            int start = Integer.parseInt(startEnd[0]);
            int step = Integer.parseInt(startEnd[1]);
            int tempResult = 0;
            for (int j = start; j < input.length; j++) {
                String[] resourse = input[j].split("[_]+");
                if(resourse.length < 2){

                }
                if (chechValid.contains(resourse[0])){
                    if (checkIfCollectet.contains(resourse[0])){
                        i = lines;
                        break;
                    }
                    if(resourse.length < 2){
                        tempResult += 1;
                        checkIfCollectet += resourse[0];
                    }else {
                        tempResult += Integer.parseInt(resourse[1]);
                        checkIfCollectet += resourse[0];
                    }
                }
                if (j + step >= input.length ){
                    j = (j + step) % input.length;
                }else{
                    j += step - 1;
                }
            }
            if (tempResult > maxResult){
                maxResult = tempResult;
            }
        }
        System.out.println(maxResult);
    }
}
