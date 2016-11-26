package HashingFunctions;

import java.util.ArrayList;

public abstract class HashingFunction {

    public abstract String getClassName();

    public abstract String getName();

    public abstract int getHashValue(long arg);

    public int getNuberOflines(ArrayList<Long> testData) {
        return testData.size();
    }

}
