package com.company;

import java.util.Scanner;

public class MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split("[\\s]+");
        String oddEven = scanner.nextLine();
        String magicCard = scanner.nextLine();
        long result = 0;
        if (oddEven.equals("odd")) {
           result =  CardCounting(cards, magicCard, 1);
        }else{
            result = CardCounting(cards, magicCard, 0);
        }
        System.out.println(result);
    }

    private static long CardCounting(String[] cards, String magicCard, int oddEvenNum) {
        long summing = 0;
        int index = 1;
        if (magicCard.length() == 3){
            index++;
        }
        char magicCardFace = magicCard.charAt(0);
        char magicCardSute = magicCard.charAt(index);

        for (int i = 0; i < cards.length; i++) {
            int tempSum = 0;
            if (i % 2 == oddEvenNum) {
                char[] array = cards[i].toCharArray();
                int suteNum = 1;
                if (array.length == 3){
                    suteNum++;
                }
                char currentFace = cards[i].charAt(0);
                char currentSute = cards[i].charAt(suteNum);
                switch (currentFace){
                    case 'A':
                        tempSum += 150;
                        break;
                    case 'J':
                        tempSum += 120;
                        break;
                    case 'Q':
                        tempSum += 130;
                        break;
                    case 'K':
                        tempSum += 140;
                        break;
                    default:
                        int num = Integer.parseInt(String.valueOf(currentFace));
                        if(num == 1){
                            num *= 10;
                        }
                        tempSum += num * 10;
                }
                if(magicCardFace == currentFace){
                    tempSum *= 3;
                }else if (magicCardSute == currentSute) {
                    tempSum *= 2;
                }
                summing += tempSum;
            }
        }
        return summing;
    }
}