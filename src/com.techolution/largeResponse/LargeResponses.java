package com.techolution.largeResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Parani on 01/04/2018.
 */
public class LargeResponses {
    private static final String FILENAME = "src/com.techolution/largeResponse/hosts_access_log_00.txt";
    public  static void main(String[] a) {

        List<String> lines= new ArrayList<>();
        BufferedReader br = null;

        FileReader fr = null;



        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        largeResponse(lines);
    }

    static void largeResponse(List<String> lines){

        int count =0;
        int totalSize=0;
        for(String log:lines){
            String[] splited = log.split("\\s+");
            if(splited.length>6){

                int byteSize = Integer.parseInt(splited[splited.length-1]);
                if(byteSize>5000){
                    count+=1;
                    totalSize+=byteSize;
                }
            }

        }
        //write it to the file
        System.out.println(count);
        System.out.println(totalSize);


    }
}
