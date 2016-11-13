package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jan Nachtigal on 11/10/2016.
 */
public class FileSave {


    public String searchDataToString(int hashValue,  Long searchableNumber, Long foundNumber){
        String searchData = null;
        searchData = "hashvalue "+hashValue+" searchable number "+searchableNumber+" found number "+foundNumber;
        return searchData;
    }

    public void saveToTxt(String fileName, String line)throws IOException{

        PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(
                fileName, true)));
        fileWriter.println(line);

        fileWriter.close();
    }
}
