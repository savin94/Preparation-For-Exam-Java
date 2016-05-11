package com.company;

import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int health = 5800;
        int glowcaps = 0;
        String input = scanner.nextLine();

        while(!input.equals("Sporeggar")){

            char[] inputArgs = input.toCharArray();
            for (int i = 0; i < inputArgs.length; i++) {
                char temp = inputArgs[i];
                if (health <= 0){
                    break;
                }
                if (temp == 'L') {
                    health += 200;
                }else if(Character.isDigit(temp) && i == inputArgs.length - 1){
                    String num = String.valueOf(temp);
                    glowcaps += Integer.parseInt(num);
                }else{
                    health -= temp;
                }
            }
            if (health <= 0){
                break;
            }
            input = scanner.nextLine();
        }
        int glowcapsNeeded = 30;
        if (health > 0 ){
            if (glowcaps >= glowcapsNeeded){

                System.out.println("Health left: " + health);
                glowcaps -= glowcapsNeeded;
                System.out.println("Bought the sporebat. Glowcaps left: " + glowcaps);
            }else{

                glowcapsNeeded -= glowcaps;
                System.out.println("Health left: " + health);
                System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.",glowcapsNeeded);
            }
        }else{
            System.out.println("Died. Glowcaps: " + glowcaps);
        }
    }
}