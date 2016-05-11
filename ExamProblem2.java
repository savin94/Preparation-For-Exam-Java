package com.company;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamProblem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowCol = scanner.nextLine().split("[\\s]+");
        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);

        String[] price = scanner.nextLine().split("[\\s]+");
        double lukanka = Double.parseDouble(price[0]);
        double rakiq = Double.parseDouble(price[1]);
        String[] command = scanner.nextLine().split("[\\s]+");
        double result = 0;
        int count = 0;
        BigDecimal finalResult  = new BigDecimal(0);
        ArrayList<Double> res  = new ArrayList<>();
        String re = "";
        while(!command[0].equals("Royal")){
            count++;
            int row = Integer.parseInt(command[0]);
            int col = Integer.parseInt(command[1]);

            if (row < col){
                res.add(rowSmallerThanCol(row, col, lukanka, rakiq));
            }else{
                res.add(rowBuiggerOrEqualToCol(row, col, lukanka, rakiq));
            }

            command = scanner.nextLine().split("[\\s]+");
        }
        for (int i = 0; i < res.size(); i++) {
            finalResult = finalResult.add(new BigDecimal(res.get(i)));

        }
        System.out.printf("%.6f", finalResult);
        System.out.println();
        System.out.println(count);
    }

    private static double rowBuiggerOrEqualToCol(
                                                 int row, int col,
                                                 double lukanka, double rakiq) {
        double prices = 0;
        while(col != 0){
            if (row % 2 != 0){
                prices += ((row + 1) * (col + 1)) * rakiq;
            }else{
                prices += ((row  + 1)* (col + 1)) * lukanka;
            }
            col--;
        }
        while(row != 0){
            if (row % 2 != 0){
                prices += ((row + 1) * (col + 1)) * rakiq;
            }else{
                prices += ((row  + 1)* (col + 1)) * lukanka;
            }
            row--;
        }
        return prices;
    }

    private static double rowSmallerThanCol(
                                            int row, int col,
                                            double lukanka, double rakiq) {
        double prices = 0;
        while(row != 0){
            if (row % 2 != 0){
                prices += ((row + 1) * (col + 1)) * rakiq;
            }else{
                prices += ((row  + 1)* (col + 1)) * lukanka;
            }
            row--;
        }
        while(col != 0){
            if (row % 2 != 0){
                prices += ((row + 1) * (col + 1)) * rakiq;
            }else{
                prices += ((row  + 1)* (col + 1)) * lukanka;
            }
            col--;
        }
        return prices;
    }
}
