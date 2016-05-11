package com.company;

import java.util.Scanner;

public class TimeSpan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[:]");

        int hours = Integer.parseInt(input[0]);
        int minutes = Integer.parseInt(input[1]);
        int seconds = Integer.parseInt(input[2]);

        String[] nextInput = scanner.nextLine().split("[:]");

        int newHours = Integer.parseInt(nextInput[0]);
        int newMinutes = Integer.parseInt(nextInput[1]);
        int newSeconds = Integer.parseInt(nextInput[2]);

        hours -= newHours;
        minutes -= newMinutes;
        if (minutes < 0){
            hours--;
            minutes += 60;
        }
        while (minutes > 59){
            hours++;
            minutes -= 60;
        }
        seconds -= newSeconds;
        if (seconds < 0){
            minutes--;
            seconds += 60;
        }
        while (seconds > 59){
            minutes++;
            seconds -= 60;
        }
        String secinds = "";
        if (seconds < 10){
            secinds = "0";
        }
        String minuteses = "";
        if (minutes < 10){
            minuteses = "0";
        }
        System.out.printf("%d:%s%d:%s%d", hours, minuteses, minutes, secinds, seconds);
    }
}
