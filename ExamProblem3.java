package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamProblem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<String> newCards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String input = scanner.nextLine();
            String[] cards = input.split("[a-z]+");
            String[] suts = input.split("[\\dA-Z]+");
            int suteCount = 0;

            for (int j = 0; j < cards.length; j++) {
                if (suts[j].equals("")) {
                    suteCount++;
                }else if (cards[j].equals("")){

                }
                newCards.add(cards[j] + suts[suteCount]);
                suteCount++;
            }
        }
        String combination = "";
        int next = 0;
        String sute = "";
        int count = 0;
        for (int i = 0; i < newCards.size(); i++) {
            String tempCard = newCards.get(i);
            if (combination.length() == 0) {
                if (tempCard.equals("10s") || tempCard.equals("10d")
                        || tempCard.equals("10c") || tempCard.equals("10h")) {
                    combination += tempCard;
                    next++;
                    char temp = tempCard.charAt(2);
                    sute = String.valueOf(temp);
                    newCards.remove(tempCard);
                    i--;
                }
            } else {
                switch (next) {

                    case 1:
                        if (!tempCard.equals("J" + sute)&&
                                !tempCard.equals("Q" + sute)
                                &&!tempCard.equals("K" + sute)
                                && !tempCard.equals("A" + sute) && !tempCard.contains(sute)){
                            next = 0;
                            combination = "";
                            sute = "";
                            i = 0;
                        }
                        if (tempCard.equals("J" + sute)) {
                            combination += tempCard;
                            next++;
                            newCards.remove(tempCard);
                            i--;
                        }
                        break;
                    case 2:
                        if (!tempCard.equals("Q" + sute) &&!tempCard.equals("K" + sute) && !tempCard.equals("A" + sute) &&
                                !tempCard.contains(sute)){
                            next = 0;
                            combination = "";
                            sute = "";
                            i = 0;
                        }
                        if (tempCard.equals("Q" + sute)) {
                            combination += tempCard;
                            next++;
                            newCards.remove(tempCard);
                            i--;
                        }
                        break;
                    case 3:
                        if (!tempCard.equals("K" + sute) && !tempCard.equals("A" + sute) && !tempCard.contains(sute)){
                            next = 0;
                            combination = "";
                            sute = "";
                            i = 0;
                        }
                        if (tempCard.equals("K" + sute)) {
                            combination += tempCard;
                            next++;
                            newCards.remove(tempCard);
                            i--;
                        }
                        break;
                    case 4:
                        if (!tempCard.equals("A" + sute) && !tempCard.contains(sute)){
                            next = 0;
                            combination = "";
                            sute = "";
                            i = 0;
                        }
                        if (tempCard.equals("A" + sute)) {
                            combination += tempCard;
                            newCards.remove(tempCard);
                            i--;
                        }
                        break;
                }
            }
            if (next == 4){
                String sutes = "";
                switch (sute){
                    case "s":
                        sutes = "Spades";
                        break;
                    case "h":
                        sutes = "Hearts";
                        break;
                    case "d":
                        sutes = "Diamonds";
                        break;
                    case "c":
                        sutes = "Clubs";
                        break;

                }
                System.out.println("Royal Flush Found - " + sutes);
                combination = "";
                next = 0;
                sute = "";
                i = 0;
                count++;
            }
        }

            System.out.println("Royal's Royal Flushes - " + count + ".");


    }
}
