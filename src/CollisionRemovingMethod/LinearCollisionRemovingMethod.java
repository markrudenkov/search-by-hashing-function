package CollisionRemovingMethod;



import HashingFunctions.HashingFunction;
import Utils.FileSave;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public class LinearCollisionRemovingMethod extends CollisionMethod {
    Long[] array;
    int arraySize;
    int hashArraySize;
    int[] hashArray ;
    private ArrayList<ArrayList<Integer>> hashInstances = new ArrayList<>();
    ArrayList<Integer> chainLengts = new ArrayList<>();


    public LinearCollisionRemovingMethod(String fileName, HashingFunction hashingFunction) throws Exception {
        this.hashingFunction = hashingFunction;
        this.hashArraySize =getHashArraySize(fileName, hashingFunction);
        hashArray = new int [this.hashArraySize];
        createDataArrayAndInputNUmbers(fileName,hashingFunction);

    }

    public int getHashArraySize(String fileName, HashingFunction hashingFunction)throws IOException{
        int arraySize = 0;
        int minArraySize = getMinimalArraySize(fileName, hashingFunction);
        int numberOflines = getNuberOflines(fileName);

      /*  int numberLength = getFirstNumberLength(fileName);
        Long maxNumber =  Long Math.pow(10,numberLength ) - 1;
        int maxHashValue = hashingFunction.getHashValue(maxNumber);*/

        if (numberOflines > minArraySize) {
            arraySize = numberOflines;
        } else {
            arraySize = minArraySize;
        }
        return arraySize;
    }

    @Override
    public void createDataArrayAndInputNUmbers(String fileName, HashingFunction hashingFunction) throws Exception {
        createDataArray(fileName,  hashingFunction);
        inputDataToArray(fileName, hashingFunction);
    }

    @Override
    public ArrayList<Integer> getChainLengts( HashingFunction hashingFunction) {
        getChains();

        return chainLengts;
    }

    @Override
    public int getEntryLenght(Long number, HashingFunction hashingFunction) throws Exception {
        Integer entryLength = 1;
        int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);

        if((!compareNumbers(number,hashValue))){
            this.countHashINstance(hashValue);
        }

        while ((!compareNumbers(number,hashValue))){
            hashValue= getNextHashValue(hashValue);
            entryLength++;
        }
        /*FileSave fileSave = new FileSave();
        String resultsOfNumberSearch = fileSave.searchDataToString(hashValue,number, array[hashValue].longValue());
        fileSave.saveToTxt("wynik_"+hashingFunction.getName()+"_"+this.getName() +".txt",resultsOfNumberSearch);*/

        return entryLength;
    }


    public void getChains(){
        for (int element  : this.hashArray){
            if(element != 0){
                chainLengts.add(element);
            }

        }
    }



    public void countHashINstance(Integer hashValue){
        /*boolean append = false;*/

        this.hashArray[hashValue]=this.hashArray[hashValue]+1;


       /* for(int i=0; i < hashInstances.size();i++){
             append = false;
            if(hashInstances.get(i).get(0) == hashValue){

                int buf = hashInstances.get(i).get(1).intValue();
                buf=buf+1;
                this.hashInstances.get(i).set(1,buf) ;
                System.out.println(hashInstances.get(i).toString());
                append = true;
            }

        }
        if (!append){
            ArrayList<Integer> hashCounter = new ArrayList<>();
            hashCounter.add(0,0);
            hashCounter.add(1,0);
            hashCounter.set(0,hashValue);
            hashInstances.add(hashCounter);
        }*/

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
                "chainLengts=" + chainLengts +
                '}';
    }

    public ArrayList<ArrayList<Integer>> getHashInstances() {
        return hashInstances;
    }

    public int[] getHashArray() {
        return hashArray;
    }
}
