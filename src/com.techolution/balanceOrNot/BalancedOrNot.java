package com.techolution.balanceOrNot;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Parani on 01/04/2018.
 */
public class BalancedOrNot {

    public  static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] expressions= new String[t];
        for(int a0 = 0; a0 < t; a0++){
            expressions[a0] = in.next();
        }
        int t1 = in.nextInt();
        int[] maxReplacements = new int[t1];
        for(int a0 = 0; a0 < t; a0++){
            maxReplacements[a0] = in.nextInt();
        }
        int[] k=balancedOrNot(expressions,maxReplacements);
        for(int g:k){
            System.out.println(g);
        }

        in.close();


    }

    public static int[] balancedOrNot(String[] expressions,int[] maxReplacements){
        int[] isPossible= new int[maxReplacements.length];

        for(int j=0; j<expressions.length;j++){
            final Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < expressions[j].length(); i++) {
                if(expressions[j].charAt(i)=='>'&&!stack.empty()&&stack.peek()=='<'){
                    stack.pop();
                }else{
                    stack.push(expressions[j].charAt(i));
                }

            }

            if(stack.size()>maxReplacements[j]){
                isPossible[j]=0;
            }else{
                isPossible[j]=1;
            }

        }

        return isPossible;

    }

}
