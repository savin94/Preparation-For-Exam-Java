package com.company;

import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String patt = scanner.nextLine();
        int lenght = patt.length() / 2;
        StringBuilder copyText = new StringBuilder();
        StringBuilder pattShaking = new StringBuilder();
        pattShaking.append(patt);
        copyText.append(text);
        int a = text.indexOf(patt);
        int s = text.lastIndexOf(patt);
        int pattLength = patt.length();
        if(text.isEmpty()){
            System.out.println("No shake.");
        }
        else if (a != -1 && s != -1) {
            copyText.delete(a, a + pattLength);
            s = copyText.lastIndexOf(patt);
            copyText.delete(s, s + pattLength);
            System.out.println("Shaked it.");
        } else {
            System.out.println("No shake.");

        }
        boolean isShaked = true;
        int countShake = 0;
        while (isShaked && !text.isEmpty()) {
            isShaked = false;
            pattShaking.delete(pattShaking.length() / 2, pattShaking.length() / 2 + 1);
            if (pattShaking.length() == 0) {
                countShake++;
                break;

            }
            int startIndex = copyText.indexOf(pattShaking.toString());
            int endIndex = copyText.lastIndexOf(pattShaking.toString());
            if (startIndex != -1 && endIndex != -1) {

                copyText.delete(startIndex, startIndex + pattShaking.length());
                endIndex = copyText.lastIndexOf(pattShaking.toString());
                copyText.delete(endIndex, endIndex + pattShaking.length());
                isShaked = true;
                System.out.println("Shaked it.");
            } else {
                System.out.println("No shake.");
            }
        }
        if (countShake != 0){
            System.out.println("No shake.");
        }
        System.out.println(copyText);
    }
}



