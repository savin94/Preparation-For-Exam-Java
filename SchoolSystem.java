package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        TreeMap<String,TreeMap<String,ArrayList<Integer>>> students = new TreeMap<>();

        for (int i = 0; i < lines; i++) {
            String[] studentsInfo = scanner.nextLine().split("[\\s]+");

            String names = studentsInfo[0] + " " + studentsInfo[1];
            String classes = studentsInfo[2];
            int grade = Integer.parseInt(studentsInfo[3]);

            TreeMap<String,ArrayList<Integer>> subjects = new TreeMap<>();

            if (students.containsKey(names)){
                subjects = students.get(names);
                if (!subjects.containsKey(classes)){
                    subjects.put(classes,new ArrayList<>());
                }
                subjects.get(classes).add(grade);
            }else{
                ArrayList<Integer> marks = new ArrayList<>();
                marks.add(grade);
                subjects.put(classes, marks);
                students.put(names, subjects);
            }
        }for ( Map.Entry<String, TreeMap<String, ArrayList<Integer>>> student : students.entrySet() ) {
            String studentName = student.getKey();
            TreeMap<String, ArrayList<Integer>> subjects = student.getValue();
            String output  = studentName + ": [";
            ArrayList<Double> avrgMarks = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Integer> > subject : subjects.entrySet()) {
                String subjectName = subject.getKey();
                Object[] marks = subject.getValue().toArray();
                output += subjectName + " - " + String.format("%.2f", averageOf(marks)) + ", ";
                avrgMarks.add(averageOf(marks));
            }

            output = output.substring(0, output.length() - 2) + "]";
            System.out.print(output + "\n");
        }

    }
    private static double averageOf(Object[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int)arr[i];
        }
        double averege = (double)sum / arr.length;
        return averege;
    }
}
