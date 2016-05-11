package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        TreeMap<String,Integer> duration = new TreeMap<>();
        HashMap<String,TreeSet<String>> parser = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("[\\s]+");
                String user = input[1];
                int durationTime  = Integer.parseInt(input[2]);
                String ip = input[0];
                Integer tempDuration = duration.get(user);
                if (tempDuration == null){
                    duration = new TreeMap<>();
                    tempDuration = 0;
                }
                duration.put(user,durationTime + tempDuration);
                TreeSet<String> ipSet = parser.get(user);
                if (ipSet == null){
                    ipSet = new TreeSet<>();

                }
                ipSet.add(ip);
                parser.put(user,ipSet);
            }

        for (Map.Entry<String, Integer> userAndDuration : duration.entrySet()) {
            String user = userAndDuration.getKey();
            int durations = userAndDuration.getValue();
            TreeSet<String> ipSet = parser.get(user);
            System.out.println(user + ": " + durations + " " + ipSet);
        }
    }
}
