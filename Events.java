package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^#([a-zA-Z]+):[\\s]*@([a-zA-Z]+)[\\s]*([\\d]{2}:[\\d]{2})$");
        int turns = scanner.nextInt();

        for (int i = 0; i < turns; i++) {
            String info = scanner.nextLine();
            Matcher matcher = pattern.matcher(info);
            if (matcher.find()){

            }
        }
    }
}
