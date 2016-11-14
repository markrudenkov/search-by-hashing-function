package CollisionRemovingMethod;



import HashingFunctions.HashingFunction;
import Utils.FileSave;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public class LinearCollisionRemovingMethod extends CollisionMethod {
    Long[] array;
    int arraySize;

    @Override
    public void createDataArrayAndInputNUmbers(String fileName, HashingFunction hashingFunction) throws Exception {
        createDataArray(fileName,  hashingFunction);
        inputDataToArray(fileName, hashingFunction);
    }

    @Override
    public int getChainlenght(Long number, HashingFunction hashingFunction) throws Exception {
        Integer chainLength = 0;
        int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);
        while ((!compareNumbers(number,hashValue))){

            hashValue= getNextHashValue(hashValue);

            chainLength++;
        }
        FileSave fileSave = new FileSave();
        String resultsOfNumberSearch = fileSave.searchDataToString(hashValue,number, array[hashValue].longValue());
        fileSave.saveToTxt("wynik_"+hashingFunction.getName()+"_"+this.getName() +".txt",resultsOfNumberSearch);

        return chainLength;
    }

    public int getNextHashValue(int nextHashValue) {
        nextHashValue--;
            if(nextHashValue<0){
                nextHashValue=arraySize-1;
            }
        return nextHashValue;
    }

    public boolean compareNumbers(Long number,int hashValue){
        try{
            return (number == array[hashValue].longValue());
        }
        catch (Exception e){
            System.out.println("number "+number+" hashvalue "+hashValue);
        }
        return (number == array[hashValue].longValue());
    }

    @Override
    public void inputDataToArray(String fileName, HashingFunction hashingFunction) throws Exception {
        //BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        int i=0;
        while ((line = reader.readLine()) != null) {

            int hashValue = getHashValueWithLoadedHashMethod(Long.parseLong(line), hashingFunction);

            if (checkIfEmptyNumberElement(hashValue)) {
                this.array[hashValue] = Long.parseLong(line);
            } else {
                Integer indexOfNewChainELement = getIndexLastEmptyElement(hashValue);
                this.array[indexOfNewChainELement] = Long.parseLong(line);
            }
            i++;
           // System.out.println("number "+Long.parseLong(line)+" hashvalue "+hashValue+" "+i);
        }
        reader.close();
    }

    public int getIndexLastEmptyElement(int hashValue) {

        while(!checkIfEmptyNumberElement( hashValue)){
            hashValue--;
            if(hashValue<0){
                hashValue=arraySize-1;
            }
        }
        return hashValue;
    }

    public boolean checkIfEmptyNumberElement(int hashValue) {
        if (this.array[hashValue] == null) return true;
        else return false;
    }


    private void createDataArray(String fileName, HashingFunction hashingFunction) throws Exception {
        int numberOflines = getNuberOflines(fileName);
        int minArraySize = getMinimalArraySize(fileName, hashingFunction);

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

    public Long[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "LinearCollisionRemovingMethod{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
