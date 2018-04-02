package com.techolution.countingGroups;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Parani on 01/04/2018.
 */
public class CountingGroups {
    private static int groupNumber = 1;
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int array[][] = new int[n][m];
        for(int i =0; i < n; i++){
            array[i] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int p = sc.nextInt();
        int[] input = new int[p];
        for(int i = 0; i < p; i++){
            input[i] = sc.nextInt();
        }
        for(int i:countGroups(array, input)){
            System.out.println(i);
        }
    }

    private static int[] countGroups(int[][] array, int[] input) {
        int[] output = new int[input.length];
        int[][] groups = count(array);
        for(int i =0; i < input.length; i++){
            output[i] = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == input[i]){
                    output[i]++;
                }
            }
        }

        return output;
    }

    private static int[][] count(int[][] array) {
        for(int i =0; i< array.length; i++){
            for(int j = 0; j< array[0].length; j++){
                if(array[i][j] == 1){
                    array[i][j] = checkGroup(array, i, j);
                    if(map.get(array[i][j]) == null){
                        map.put(array[i][j], 1);
                    }else{
                        map.put(array[i][j], map.get(array[i][j]) + 1);
                    }
                }
            }
        }

        return array;
    }

    private static int checkGroup(int[][] array, int i, int j){
        if(i > 0 && array[i-1][j] > 1){
            return array[i-1][j];
        }else if(j > 0 && array[i][j-1] > 1){
            return array[i][j-1];
        }else if(i < array.length -1 && array[i+1][j] > 1){
            return array[i+1][j];
        }else if(j < array[0].length -1 && array[i][j+1] > 1){
            return array[i][j+1];
        } else{
            groupNumber++;
            return groupNumber;
        }
    }
}