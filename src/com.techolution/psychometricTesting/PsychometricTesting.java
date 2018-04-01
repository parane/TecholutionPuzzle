package com.techolution.psychometricTesting;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class PsychometricTesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores= new int[n];
        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }
        int ln=sc.nextInt();
        int[] lowerLimit= new int[ln];
        for(int i = 0; i < ln; i++){
            lowerLimit[i] = sc.nextInt();
        }
        int un=sc.nextInt();
        int[] upperLimit= new int[un];
        for(int i = 0; i < un; i++){
            upperLimit[i] = sc.nextInt();
        }

        int[] r= jobOffers(scores,lowerLimit,upperLimit);
        for(int k:r){
            System.out.println(k);

        }
    }

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[]
            upperLimits){

        int[] joboffers= new int[lowerLimits.length];
        for(int score:scores){

            for(int k=0;k<lowerLimits.length;k++){
                if(score>=lowerLimits[k]&&score<=upperLimits[k]){
                    joboffers[k]= joboffers[k]+1;
                }
            }

        }

        return joboffers;
    }

}
