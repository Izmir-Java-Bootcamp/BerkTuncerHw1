package com.kodluyoruz;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the pattern string: ");
        String pattern = scan.nextLine();
        System.out.println();

        String str = "";

        while(true) {

            System.out.print("Enter a string: ");
            str = scan.nextLine();

            if (str.equals("exit")){
                System.out.println("Bye");
                break;
            }

            occursIn(pattern, str);

        }

    }

    public static void occursIn(String pattern, String str){

        String compare = "";

        for (int i = 0; i < pattern.length(); i++){
            if (pattern.charAt(i) != '*'){

                compare += pattern.charAt(i);

            }
        }

        String control = "";

        int i = 0;
        int j = 0;

        while(i < compare.length()){

            if (compare.charAt(i) == str.charAt(j)){

                control += str.charAt(j);
                i++;

            }

            j++;

            if (j >= str.length())
                break;
        }

        if (compare.equals(control)){
            System.out.println(pattern + " occurs in " + "\"" + str + "\"");
        }
        else{
            System.out.println(pattern + " does NOT occur in " + "\"" + str + "\"");
        }
        System.out.println();

    }
}
