package com.company.HashingFunctions;

import com.company.HashingFunctions.HashingFunction;

/**
 * Created by Jan Nachtigal on 10/15/2016.
 */
public class HashingFunction3 extends HashingFunction {
    double a =  0.0000002;
    int m= 10000;


    public HashingFunction3() {
    }

    public HashingFunction3(double a, int m) {
        this.a = a;
        this.m = m;
    }

    public int getHashValue(long arg){
        int hashValue = (int) (m * ((arg * a) % 1));
        return hashValue;
    }

    public String getClassName(){
        return "com.company.HashingFunctions.HashingFunction3";
    }

    public String getName(){
        return "HashingFUnction3";
    }

}
