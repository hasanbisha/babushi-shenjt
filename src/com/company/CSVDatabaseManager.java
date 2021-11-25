package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVDatabaseManager {
    public static ArrayList<String[]> getCSVFileLines(String fileName) {
        ArrayList<String[]> lineList = new ArrayList<String[]>();
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine();
            while ((line = br.readLine()) != null) {
                lineList.add(line.split(","));
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return lineList;
    }
}
