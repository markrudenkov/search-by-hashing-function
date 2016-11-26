package CollisionRemovingMethod;

import HashingFunctions.HashingFunction;

import java.lang.*;
import java.util.ArrayList;

public class SecondCollisionRemovingMethod extends CollisionMethod {

    Long[][] array; // array[x][0] - number element; array[x][1] - pointer element
    double arraySpareSpace = 1.5;

    public SecondCollisionRemovingMethod(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        this.hashingFunction = hashingFunction;
        this.hashArraySize = getHashArraySize(testData, hashingFunction);
        hashArray = new int[this.hashArraySize];
        createDataArrayAndInputNUmbers(testData, hashingFunction);
    }

    @Override
    public int getEntryLenght(Long number, HashingFunction hashingFunction) throws Exception {
        Integer entryLength = 1;
        int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);
        if ((!compareNumbers(number, hashValue))) {
            this.countHashINstance(hashValue);
        }

        while ((!compareNumbers(number, hashValue))) {
            hashValue = Long.valueOf(array[hashValue][1]).intValue();
            entryLength++;
        }
        return entryLength;
    }

    @Override
    public boolean compareNumbers(Long number, int hashValue) {
        return (number == array[hashValue][0].longValue());
    }

    @Override
    public void createDataArrayAndInputNUmbers(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        createDataArray(testData, hashingFunction);
        inputDataToArray(testData, hashingFunction);
    }

    public String getClassName() {
        return "CollisionRemovingMethod.SecondCollisionRemovingMethod";
    }

    public String getName() {
        return "SecondCollisionRemovingMethod";
    }

    public void inputDataToArray(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        for (Long number : testData) {
            int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);
            if (checkIfEmptyNumberElement(hashValue)) {
                this.array[hashValue][0] = number;
            } else {
                Integer indexOfPredecessorOfLastChainElement = getChainElementWithEmptyPointer(hashValue);
                Integer indexOfNewChainELement = getIndexLastEmptyElement();
                this.array[indexOfNewChainELement][0] = number;
                this.array[indexOfPredecessorOfLastChainElement][1] = indexOfNewChainELement.longValue();
            }
        }
    }

    public int getChainElementWithEmptyPointer(int hashValue) {
        Long pointer = Long.parseLong(String.valueOf(hashValue));
        int currentHashValue = hashValue;
        while (pointer != null) {
            currentHashValue = pointer.intValue();
            pointer = this.array[pointer.intValue()][1];
        }
        return currentHashValue;
    }

    private void createDataArray(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception {
        int numberOflines = getNuberOflines(testData);
        int minArraySize = getMinimalArraySize(testData, hashingFunction);
        if (numberOflines > minArraySize) {
            this.array = new Long[(int) (numberOflines * arraySpareSpace)][2];
        } else {
            this.array = new Long[(int) (minArraySize * arraySpareSpace)][2];
        }
    }

    public int getIndexLastEmptyElement() {
        int indexLastEmptyElement = 0;
        for (int i = this.array.length - 1; i > 0; i--) {
            if (checkIfEmptyNumberElement(i)) {
                indexLastEmptyElement = i;
                break;
            }
        }
        return indexLastEmptyElement;
    }

    public boolean checkIfEmptyNumberElement(int hashValue) {
        if (this.array[hashValue][0] == null) return true;
        else return false;
    }
}
