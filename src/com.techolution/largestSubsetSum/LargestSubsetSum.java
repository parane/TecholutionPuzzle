package com.techolution.largestSubsetSum;

import java.util.Scanner;

/**
 * Created by Parani on 01/04/2018.
 */
public class LargestSubsetSum {
    public static void main(String [] a){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] k =new int[n];

        for(int a0 = 0; a0 < n; a0++){
            k[a0] = in.nextInt();
        }
        long[] l= maxSubsetSum(k);
        for(long res:l){
            System.out.println(res);

        }
        in.close();
    }

    public static long[] maxSubsetSum(int[] k){
        long[] sums = new long[k.length];

        for(int j=0;j<k.length;j++) {
            int LIM = (int) Math.sqrt(k[j]);
            long sum=0;
            for (int i = 1; i <= LIM; i++) {
                if (k[j] % i == 0) {

                    if (i == (k[j] / i))
                        sum += i;
                    else
                        sum += (i + k[j] / i);
                }
            }
            sums[j]=sum;
        }

        return sums;
    }
}
