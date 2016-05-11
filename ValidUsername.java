package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[\\s()\\/\\\\]+");
        Pattern pattern = Pattern.compile("\\b[a-zA-Z][a-zA-Z\\d_]{2,25}\\b");
        ArrayList<String> validUsernames = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()){
                validUsernames.add(matcher.group());
            }
        }
        int maxSize = 0;
        String firstPair = "";
        String secondPair = "";
        for (int i = 0; i < validUsernames.size() - 1; i++) {
            int size = validUsernames.get(i).length() +
                    validUsernames.get(i + 1).length();

            if (size > maxSize){
                firstPair = validUsernames.get(i);
                secondPair = validUsernames.get(i + 1);
                maxSize = size;
            }
        }
        System.out.println(firstPair);
        System.out.println(secondPair);
    }
}
