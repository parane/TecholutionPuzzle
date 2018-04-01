package com.techolution.twoCircle;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class TwoCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] info = new String[n];
        for(int i = 0; i < n; i++){
            info[i] = sc.nextLine();
        }

        String[] output = circles(info);
        for(String o: output){
            System.out.println(o);
        }
    }

    private static String[] circles(String[] info) {
        String[] output = new String[info.length];
        for(int i = 0; i < output.length; i++){
            String[] input = info[i].split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            if(x1 == x2 && y1 == y2){
                output[i] = "Concentric";
            } else if(r1 + r2 == Math.abs((x1-x2+y1-y2)) || Math.abs(r1-r2) == Math.abs((x1-x2+y1-y2))){
                output[i] = "Touching";
            } else if(r1 + r2 < Math.abs((x1 - x2 + y1 - y2))){
                output[i] = "Disjoint‐Outside";
            } else if ((r1 > r2 && (x2-x1+y2-y1+r2 < r1)) || (r2 > r1 && (x1-x2+y1-y2+r1 < r2))) {
                output[i] = "Disjoint‐Inside";
            } else{
                output[i] = "Intersecting";
            }
        }
        return output;
    }
}