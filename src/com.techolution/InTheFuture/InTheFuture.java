package com.techolution.InTheFuture;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class InTheFuture {
    public  static void main(String[] a) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int K = in.nextInt();
        int P = in.nextInt();

        System.out.println(minNum(A,K,P));
    }

    public static int minNum(int A, int K, int P){
        if(A>=K){
            return -1;
        }else if((K-A)==P){
            return 2;
        }

        return (int) Math.ceil(((double) P)/(K-A));

    }
}
