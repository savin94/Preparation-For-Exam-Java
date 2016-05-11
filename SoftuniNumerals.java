package com.company;

import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;

public class SoftuniNumerals{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        String number = "";
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("a") && input[i + 1].equals("a")) {
                number += 0;
                i = i + 1;
            } else if (input[i].equals("a") && input[i + 1].equals("b")) {
                number += 1;
                i = i + 2;
            } else if (input[i].equals("b") && input[i + 1].equals("c")) {
                number += 2;
                i = i + 2;
            } else if (input[i].equals("c") && input[i + 1].equals("c")) {
                number += 3;
                i = i + 1;
            } else if (input[i].equals("c") && input[i + 1].equals("d")) {
                number += 4;
                i = i + 2;
            }
        }
        long parser =   Long.valueOf(number.toString(), 5);
        System.out.println(parser);
    }
}