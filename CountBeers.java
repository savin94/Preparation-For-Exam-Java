package com.company;

import java.util.Scanner;

public class CountBeers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int stacks = 0;
        int beers = 0;
        while(!input.equals("End")){

            String[] tokens = input.split("[\\s]+");
            if (tokens[1].equals("stacks")){
                stacks += Integer.parseInt(tokens[0]);
            }else{
                beers += Integer.parseInt(tokens[0]);
                if (beers >= 20);
                while(beers >= 20){
                    beers -= 20;
                    stacks += 1;
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("%d stacks + %d beers",stacks, beers);
    }
}
