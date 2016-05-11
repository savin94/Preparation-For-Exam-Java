package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cards = scanner.nextLine();
        ArrayList<Integer> summing = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\dAQJK]+");
        Matcher matcher = pattern.matcher(cards);

        while (matcher.find()) {
            if (matcher.group().equals("J")) {
                summing.add(12);
            } else if (matcher.group().equals("Q")) {
                summing.add(13);
            } else if (matcher.group().equals("A")) {
                summing.add(15);
            } else if (matcher.group().equals("K")) {
                summing.add(14);
            } else {
                summing.add(Integer.parseInt(matcher.group()));
            }
        }
        int tempSum = 0;
        int result = 0;
        int count = 1;
        for (int i = 0; i < summing.size(); i++) {
             count = 1;
             tempSum = 0;
            for (int j = i + 1; j < summing.size(); j++) {

                if (summing.get(i) == summing.get(j)) {
                    count++;
                    i = j;
                } else {
                    break;
                }
            }
            tempSum = summing.get(i) * count;
            if (count != 1) {
                tempSum *= 2;
            }

                result += tempSum;
            }
            System.out.println(result);
        }
    }


