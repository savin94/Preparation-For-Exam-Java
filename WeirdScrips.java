package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScrips {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int keyNumber = Integer.parseInt(scn.nextLine());
        keyNumber = keyNumber - 1;
        int charCode = keyNumber % 26;
        char letter = 'a';

        if ((keyNumber / 26) % 2 == 0){
            letter += charCode;
        }else{
         letter =   Character.toUpperCase(letter += charCode);
        }
        String newLetter = String.valueOf(letter);
        newLetter = newLetter + newLetter;
        StringBuilder lines = new StringBuilder();

        String input = scn.nextLine();
        while(!input.equals("End")){
            lines.append(input);
            input = scn.nextLine();
        }
        Pattern pattern = Pattern.compile(newLetter + "(.*?)" + newLetter);
        String message = lines.toString();
        Matcher matcher = pattern.matcher(message);

        while(matcher.find()){
            if (matcher.group(1).length() > 0){
                System.out.println(matcher.group(1));
            }
        }
    }
}
