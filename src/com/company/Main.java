package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            readFromFile("Holmes");
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }
    public static void readFromFile(String searchedPhrase)
            throws FileNotFoundException {

        ArrayList<Integer> list = new ArrayList<>(); // var list - holding the position of the matches
        int counter=0, line=0;
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>(); // hm - holder of the line and the index
        int a=1;
        Scanner txtscan = new Scanner(new File("48320-0.txt")); // pointing to the file we are working with
        while(txtscan.hasNextLine()){ // circling through the file till the end of it
            line++;
            String str = txtscan.nextLine();
            int indOf = str.indexOf(searchedPhrase);

                if (indOf != -1) {
                    hm.put(line, str.indexOf(searchedPhrase));
                    counter++;
//                    if (str.indexOf(searchedPhrase, indOf + searchedPhrase.length()) != -1) {
//                        hm.put(line, str.indexOf(searchedPhrase));
//                        counter++;
//                        indOf= indOf+searchedPhrase.length();
//                    }

            }

        }
        for(Integer key : hm.keySet()){
            System.out.println("line: "+key + " "+ " index: "+hm.get(key));
        }
        System.out.println();
        System.out.println(counter);

    }
}



