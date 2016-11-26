package Utils;

import java.io.BufferedReader;
import java.util.ArrayList;

public class FileReader {
    ArrayList<Long> testData = new ArrayList<>();

    public ArrayList<Long> readData(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
        String line = null;
        while ((line = reader.readLine()) != null) {
            testData.add(Long.parseLong(line));
        }
        reader.close();
        return testData;
    }
}
