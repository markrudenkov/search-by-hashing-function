package CollisionRemovingMethod;


import HashingFunctions.HashingFunction;
import HashingFunctions.HashingFunction3;
import Utils.FileSave;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SecondCollisionRemovingMethod extends CollisionMethod {

    Long[][] array; // array[x][0] - number element; array[x][1] - pointer element

    public int getChainlenght(Long number,HashingFunction hashingFunction) throws Exception {
        Integer chainLength = 0;
        int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);

        if (array[hashValue][1] == null) {
            System.out.println("Hahvalue "+hashValue+ " number "+ array[hashValue][0]+" pointer "+array[hashValue][1]);

        }


        while ((!compareNumbers(number,hashValue))){
                hashValue= Long.valueOf(array[hashValue][1]).intValue();


                chainLength++;
        }
        FileSave fileSave = new FileSave();
        String resultsOfNumberSearch = fileSave.searchDataToString(hashValue,number, array[hashValue][0].longValue());
        fileSave.saveToTxt("wynik_"+hashingFunction.getName()+"_"+this.getName() +".txt",resultsOfNumberSearch);

        return chainLength;
    }

    public boolean compareNumbers(Long number,int hashValue){
        return (number == array[hashValue][0].longValue());
    }

    public void createDataArrayAndInputNUmbers(String fileName, HashingFunction hashingFunction) throws Exception {
        createDataArray(fileName,  hashingFunction);
        inputDataToArray(fileName, hashingFunction);
    }

    public String getClassName(){
        return "CollisionRemovingMethod.SecondCollisionRemovingMethod";
    }

    public String getName(){
        return "SecondCollisionRemovingMethod";
    }

    public void inputDataToArray(String fileName,HashingFunction hashingFunction) throws Exception {
        //BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;

        while ((line = reader.readLine()) != null) {
           // int hashValue = hashingFunction3.getHashValue(Long.parseLong(line));
            int hashValue = getHashValueWithLoadedHashMethod(Long.parseLong(line), hashingFunction);

            if (checkIfEmptyNumberElement(hashValue)) {
                this.array[hashValue][0] = Long.parseLong(line);
            } else {
                Integer indexOfPredecessorOfLastChainElement = getChainElementWithEmptyPointer(hashValue);
                Integer indexOfNewChainELement = getIndexLastEmptyElement();
                this.array[indexOfNewChainELement][0] = Long.parseLong(line);
                this.array[indexOfPredecessorOfLastChainElement][1] = indexOfNewChainELement.longValue();
            }
        }
        reader.close();
    }

    public int getChainElementWithEmptyPointer(int hashValue) {
        Long pointer = Long.parseLong(String.valueOf(hashValue));
        int currentHashValue = hashValue;

        while (pointer != null) {
            currentHashValue=pointer.intValue();
            pointer = this.array[pointer.intValue()][1];
        }
        return currentHashValue;
    }

    private void createDataArray(String fileName, HashingFunction hashingFunction) throws Exception {
        int numberOflines = getNuberOflines(fileName);
        int minArraySize = getMinimalArraySize(fileName, hashingFunction);

        if (numberOflines > minArraySize) {
            this.array = new Long[numberOflines][2];
        } else {
            this.array = new Long[minArraySize][2];
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

    public boolean checkIfEmptyPointerElement(int hashValue) {
        if (this.array[hashValue][1] == null) return true;
        else return false;
    }


    @Override
    public String toString() {
        return "SecondCollisionRemovingMethod{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public Long[][] getArray() {
        return array;
    }

    public void setArray(Long[][] array) {
        this.array = array;
    }
}
