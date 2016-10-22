/*
 * Main
 * Homework1 v 0.0.0.0001
 * No copyrights
 */

package com.koldmit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String rawNumber;
        long phNumber;
        int iterNum = 1;
        Scanner s = new Scanner(System.in);
        String[] finalResult = {"Nil", "One", "Two", "Three", "Four", "5", "6", "7", "8", "9"};
        while (true) {
            System.out.println("Plz enter phone number:");
            rawNumber = s.nextLine();
            if (rawNumber.matches("^\\+?(8|38)?(\\(?\\d{3}\\)?){1}([\\s\\-]?\\d){7}$")) {
                break;
            }
            else {
                System.out.print("Number is not very good... ");
            }
        }
        rawNumber = rawNumber.replaceAll("[^0-9]","");
        try {
            phNumber = Long.parseLong(rawNumber);
        } catch (NumberFormatException e) {
            System.out.println("Something goes wrong. bb :( ");
            return;
        }
        while (phNumber / 10 != 0) {
            long k = phNumber;
            long pSum = 0;
            while (k != 0) {
                pSum += k % 10;
                k = k / 10;
            }
            phNumber = pSum;
            System.out.format("Round of calculation # %d, sum is %d %n", iterNum, phNumber);
            iterNum++;
        }
        System.out.println("Final result is " + finalResult[(int) phNumber]); //некрасиво с приведением, но уже почти четрые утра :)
    }
}
