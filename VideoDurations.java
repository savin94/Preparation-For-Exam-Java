package com.company;

import java.util.Scanner;

public class VideoDurations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int hours = 0;
        int minutes = 0;
        while(!input.equals("End")){
            String[] hoursMinutes = input.split("[:]+");
            hours += Integer.parseInt(hoursMinutes[0]);
            minutes += Integer.parseInt(hoursMinutes[1]);

            while (minutes > 59){
                hours += 1;
                minutes -= 60;
            }
            input = scanner.nextLine();
        }
        String newMinutes = String.valueOf(minutes);
        if (minutes < 10){
            newMinutes = "0" + newMinutes;
        }
        System.out.println(hours + ":" + newMinutes);
    }
}
