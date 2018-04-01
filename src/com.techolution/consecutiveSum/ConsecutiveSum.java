package com.techolution.consecutiveSum;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class ConsecutiveSum {
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(consecutive(n));
        sc.close();

    }
    public  static int consecutive(long num){
        int count = 0;
        for (long range = 1; range * (range + 1) < 2 * num; range++)
        {
            double a = (double) ((1.0 * num-(range * (range + 1)) / 2) / (range + 1));
            if (a-(int)a == 0.0)
                count++;
        }
        return count;
    }
}
