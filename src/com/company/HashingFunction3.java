package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Jan Nachtigal on 10/15/2016.
 */
public class HashingFunction3 {
    double a =  0.0000002;
    int m= 10000;


    public int getHashValue(long arg){
        int hashValue = (int) (m * ((arg * a) % 1));
        return hashValue;
    }



}
