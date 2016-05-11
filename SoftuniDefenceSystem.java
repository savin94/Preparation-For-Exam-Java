package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniDefenceSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern patt = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]+).*?([\\d]+)L");
        String input = scanner.nextLine();
        double liter = 0;
        while(!input.equals("OK KoftiShans")){
            Matcher match = patt.matcher(input);
            while (match.find()){
                String name = match.group(1);
                String alcohol = match.group(2).toLowerCase();
                int liters = Integer.parseInt(match.group(3));
                liter += liters;
                System.out.printf("%s brought %d liters of %s!",name,liters,alcohol);
                System.out.println();
            }
            input = scanner.nextLine();
        }
        double resultLiters = liter / 1000;
        System.out.printf("%.3f softuni liters",resultLiters);
    }
}
