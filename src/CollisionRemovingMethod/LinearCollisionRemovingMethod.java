package CollisionRemovingMethod;
import HashingFunctions.HashingFunction;
import java.util.ArrayList;

public class LinearCollisionRemovingMethod extends CollisionMethod {
    Long[] array;
    int arraySize;

    public LinearCollisionRemovingMethod(ArrayList<Long> testData , HashingFunction hashingFunction) throws Exception {
        this.hashingFunction = hashingFunction;
        this.hashArraySize = getHashArraySize(testData, hashingFunction);
        hashArray = new int[this.hashArraySize];
        createDataArrayAndInputNUmbers(testData, hashingFunction);
    }

    @Override
    public void createDataArrayAndInputNUmbers(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        createDataArray(testData, hashingFunction);
        inputDataToArray(testData, hashingFunction);
    }

    @Override
    public int getEntryLenght(Long number, HashingFunction hashingFunction) throws Exception {
        Integer entryLength = 1;
        int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);

        if ((!compareNumbers(number, hashValue))) {
            this.countHashINstance(hashValue);
        }

        while ((!compareNumbers(number, hashValue))) {
            hashValue = getNextHashValue(hashValue);
            entryLength++;
        }
        return entryLength;
    }

    public int getNextHashValue(int nextHashValue) {
        nextHashValue--;
        if (nextHashValue < 0) {
            nextHashValue = arraySize - 1;
        }
        return nextHashValue;
    }

    @Override
    public boolean compareNumbers(Long number, int hashValue) {
        return (number == array[hashValue].longValue());
    }

    @Override
    public void inputDataToArray(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        for(Long number : testData){
            int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);
            if (checkIfEmptyNumberElement(hashValue)) {
                this.array[hashValue] = number;
            } else {
                Integer indexOfNewChainELement = getIndexLastEmptyElement(hashValue);
                this.array[indexOfNewChainELement] = number;
            }
        }
    }

    public int getIndexLastEmptyElement(int hashValue) {

        while (!checkIfEmptyNumberElement(hashValue)) {
            hashValue--;
            if (hashValue < 0) {
                hashValue = arraySize - 1;
            }
        }
        return hashValue;
    }

    public boolean checkIfEmptyNumberElement(int hashValue) {
        if (this.array[hashValue] == null) return true;
        else return false;
    }

    private void createDataArray(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        int numberOflines = getNuberOflines(testData);
        int minArraySize = getMinimalArraySize(testData, hashingFunction);

        if (numberOflines > minArraySize) {
            this.arraySize = numberOflines;
        } else {
            this.arraySize = minArraySize;
        }
        this.array = new Long[arraySize];

    }

    @Override
    public String getClassName() {
        return "CollisionRemovingMethod.LinearCollisionRemovingMethod";
    }

    @Override
    public String getName() {
        return "LinearCollisionRemovingMethod";
    }

}
