package HashingFunctions;

import HashingFunctions.HashingFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jan Nachtigal on 10/15/2016.
 */
public class HashingFunction3 extends HashingFunction {
    double a = 0.1;
    int m = 10000000;




    public HashingFunction3(String fileName) throws IOException {
        setAtributes(fileName);
    }

    public void setAtributes(String filename) throws IOException {
        getMValue(this.getNuberOflines(filename) ,filename);
        a /= m;
    }

    public void getMValue(int numberOfLines, String fileName) throws IOException {
        int minM = String.valueOf(numberOfLines).length();
        int lenght;
        int maxM = getFirstNumbeLength(fileName);
        if (maxM < minM) {
            lenght = maxM;
        }
        else {
            lenght = minM;
        }

        int m= (int) Math.pow(10, lenght);



    }


    public int getFirstNumbeLength(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lineLength = reader.readLine().length();
        reader.close();
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
