package HashingFunctions;

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

    public HashingFunctionModular(String filename) throws IOException {
        numberOfLines = this.getNuberOflines(filename);
        modularValue = (int) numberOfLines ;
        PrimeNumber primeNumber = new PrimeNumber();
        modularValue = primeNumber.getPrimeNumber(modularValue);

    }



    @Override
    public String getClassName() {
        return "HashingFunctions.HashingFunctionModular";
    }

    @Override
    public String getName() {
        return "HashingFunctionModular";
    }
}
