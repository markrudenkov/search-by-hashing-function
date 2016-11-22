package HashingFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public abstract class HashingFunction  {
public abstract String getClassName();
    public abstract String getName();
    public abstract int getHashValue(long arg);

    public int getNuberOflines(String fileName) throws IOException {
        int lines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }

}
