package com.company.HashingFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public class HashingFunctionModular extends HashingFunction {

    int numberOfLines;
    int modularValue;

    @Override
    public int getHashValue(long arg) {
        int hashvalue = (int) (arg % modularValue);
        return hashvalue;
    }

    public HashingFunctionModular(int aproximateChainLength, String filename) throws IOException {
        numberOfLines = this.getNuberOflines(filename);
        modularValue = (int) numberOfLines / aproximateChainLength;
        PrimeNumber primeNumber = new PrimeNumber();
        modularValue = primeNumber.getPrimeNumber(modularValue);

    }

    public int getNuberOflines(String fileName) throws IOException {
        int lines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }

    @Override
    public String getClassName() {
        return "com.company.HashingFunctions.HashingFunctionModular";
    }

    @Override
    public String getName() {
        return "HashingFunctionModular";
    }
}
