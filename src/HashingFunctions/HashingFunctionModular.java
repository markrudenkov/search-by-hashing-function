package HashingFunctions;

import java.io.IOException;
import java.util.ArrayList;

public class HashingFunctionModular extends HashingFunction {

    private int numberOfLines;
    private int modularValue;

    @Override
    public int getHashValue(long arg) {
        int hashvalue = (int) (arg % modularValue);
        return hashvalue;
    }

    public HashingFunctionModular(ArrayList<Long> testData) throws IOException {
        numberOfLines = this.getNuberOflines(testData);
        PrimeNumber primeNumber = new PrimeNumber();
        modularValue = primeNumber.getPrimeNumber(numberOfLines);
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
