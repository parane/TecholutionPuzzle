package com.techolution.findWinner;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class findTheWinner {
    public  static void main(String[] a) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] andrea = new int[t];
        for (int a0 = 0; a0 < t; a0++) {
            andrea[a0] = in.nextInt();
        }
        int t1 = in.nextInt();
        int[] maria = new int[t1];
        for (int a0 = 0; a0 < t; a0++) {
            maria[a0] = in.nextInt();
        }
        String type = in.next();

        System.out.println(winner(andrea,maria,type));
        in.close();
    }

    static String winner(int[] andrea,int[] maria, String s){

        int andreaScore=0;
        int mariaScore=0;


        for(int i=0;i<andrea.length;i++){
            if(s.equalsIgnoreCase("odd") && (i%2==1) ){

                andreaScore = andreaScore + (andrea[i]-maria[i]);
                mariaScore = mariaScore + (maria[i] -andrea[i]);

            }else if(s.equalsIgnoreCase("even") && (i%2==0) ){
                andreaScore = andreaScore + (andrea[i]-maria[i]);
                mariaScore = mariaScore + (maria[i] -andrea[i]);
            }

        }

        if(mariaScore==andreaScore){
            return "Tie";
        }else if(mariaScore>andreaScore){
            return "Maria";
        }else{
            return "Andrea";
        }
    }
}
