package CollisionRemovingMethod;

import HashingFunctions.HashingFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class CollisionMethod {

    int hashArraySize;
    int[] hashArray ;
    private ArrayList<Integer> chainLengts = new ArrayList<>();

    public abstract String getClassName();
    public abstract String getName();
    public abstract int getEntryLenght(Long number,HashingFunction hashingFunction) throws Exception;

    public abstract boolean compareNumbers(Long number, int hashValue);

    public abstract void inputDataToArray(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception;
    public abstract void createDataArrayAndInputNUmbers(ArrayList<Long> testData, HashingFunction hashingFunction) throws Exception;
    HashingFunction hashingFunction;

    public int getNuberOflines(ArrayList<Long> testData) {
        return testData.size();
    }

    public int getHashValueWithLoadedHashMethod(Long line,HashingFunction hashingFunction) throws Exception {

        Class myclass = Class.forName(hashingFunction.getClassName());
        int hashValue=0;
        Method[] methods = myclass.getMethods();

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("getHashValue")) {
                hashValue= (int) methods[i].invoke(hashingFunction,line);
            }
        }
        return hashValue;
    }

    public void countHashINstance(Integer hashValue){
        this.hashArray[hashValue]=this.hashArray[hashValue]+1;
    }

    public int getHashArraySize(ArrayList<Long> testData, HashingFunction hashingFunction)throws IOException{
        int arraySize = 0;
        int minArraySize = getMinimalArraySize(testData, hashingFunction);
        int numberOflines = getNuberOflines(testData);

        if (numberOflines > minArraySize) {
            arraySize = numberOflines;
        } else {
            arraySize = minArraySize;
        }
        return arraySize;
    }

    public int getMinimalArraySize(ArrayList<Long> testData, HashingFunction hashingFunction)throws IOException{
        int hashvalueLength = String.valueOf(getFirstNumberHashvalue(testData, hashingFunction)).length();
        int minArraySize = (int) Math.pow(10,hashvalueLength ) - 1;
        return minArraySize;
    }

    public int getFirstNumberHashvalue(ArrayList<Long> testData, HashingFunction hashingFunction) throws IOException {
        return hashingFunction.getHashValue(testData.get(0));
    }

    public int getFirstNumberLength(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lenght  = reader.readLine().length();
        return lenght;
    }

    public HashingFunction getHashingFunction() {
        return hashingFunction;
    }

    public void getChains(){
        for (int element  : this.hashArray){
            if(element != 0){
                chainLengts.add(element);
            }
        }
    }

    public ArrayList<Integer> getChainLengts(HashingFunction hashingFunction) {
        getChains();
        return chainLengts;
    }


}
