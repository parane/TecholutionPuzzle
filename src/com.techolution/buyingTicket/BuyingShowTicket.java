package com.techolution.buyingTicket;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class BuyingShowTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i=0; i < n; i++){
            array[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        System.out.println(findWaitingTime(array, p));
        sc.close();
    }

    private static int findWaitingTime(int[] array, int p) {
        int time = 0;
        int i =0;
        while(array[p] != 0){
            if(array[i] > 0){
                time++;
                array[i] = array[i] - 1;
            }
            i++;

            if(i == array.length){
                i = 0;
            }
        }
        return time;
    }
}
