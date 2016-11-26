package HashingFunctions;

import java.io.IOException;
import java.util.ArrayList;

public class HashingFunction3 extends HashingFunction {

    double a = 0.2;
    int m = 1000000;

    public HashingFunction3(ArrayList<Long> testData) throws IOException {
        setAtributes(testData);
    }

    public void setAtributes(ArrayList<Long> testData) throws IOException {
        getMValue(this.getNuberOflines(testData), testData);
        a /= m;
    }

    public void getMValue(int numberOfLines, ArrayList<Long> testData) throws IOException {
        int minM = String.valueOf(numberOfLines).length();
        int lenght;
        int maxM = getFirstNumbeLength(testData);
        if (maxM < minM) {
            lenght = maxM;
        } else {
            lenght = minM;
        }

        this.m = (int) Math.pow(10, lenght);
    }

    public int getFirstNumbeLength(ArrayList<Long> testData) throws IOException {
        int lineLength = testData.get(0).toString().length();
        return lineLength;
    }

    public int getHashValue(long arg) {
        int hashValue = (int) (m * ((arg * a) % 1));
        return hashValue;
    }

    public String getClassName() {
        return "HashingFunctions.HashingFunction3";
    }

    public String getName() {
        return "HashingFUnction3";
    }
}
