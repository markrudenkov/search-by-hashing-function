package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SecondCollisionRemovingMethod {

    HashingFunction3 hashingFunction3 = new HashingFunction3();
    Long[][] array; // array[x][0] - number element; array[x][1] - pointer element



    public int getChainlenght(Long number,String hashingFunction) throws Exception {
        Integer chainLength = 0;
        int hashValue = getHashValueWithLoadedHashMethod(number, hashingFunction);
       // System.out.println("NUmber "+number+" hashvalue "+hashValue);
        while ((!compareNumbers(number,hashValue))){

            try{
                hashValue= Long.valueOf(array[hashValue][1]).intValue();
                System.out.println("hashvalue" + hashValue+" number "+ Long.valueOf(array[hashValue][0])+" searchable number "+number );

            }catch (NullPointerException e){
                System.out.println("Broken hashvalue" + hashValue+" number "+ Long.valueOf(array[hashValue][0])+" number comparable "+number );
                break;

            }


            chainLength++;
        }
        // maybe write to file????
        FileSave fileSave = new FileSave();
        String resultsOfNumberSearch = fileSave.searchDataToString(hashValue,number, array[hashValue][0].longValue());
        fileSave.saveToTxt("wynik.txt",resultsOfNumberSearch);

        return chainLength;
    }

    public boolean compareNumbers(Long number,int hashValue){
        return (number == array[hashValue][0].longValue());
    }


    public void createDataArrayAndInputNUmbers(String fileName, String hashingFunction) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        getNuberOflines(fileName);
        createDataArray(fileName);
        inputDataToArray(fileName, hashingFunction);
    }



    public int getHashValueWithLoadedHashMethod(Long line,String hashingFunction) throws Exception {

        Class myclass = Class.forName(hashingFunction);
        int hashValue=0;
        Method[] methods = myclass.getMethods();
        Object object = myclass.newInstance();

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("getHashValue")) {
                hashValue= (int) methods[i].invoke(object,line);
            }
        }
        return hashValue;
    }

    public String getSecondColissionRemovingMethod(){
        return "com.company.SecondCollisionRemovingMethod";
    }


    public void inputDataToArray(String fileName,String hashingFunction) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
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

    public int getIndexLastEmptyElement(int index) {
        int indexLastEmptyElement = 0;
        for (int i = index; i > 0; i--) {
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

    public void createDataArray(String fileName) throws Exception {
        int numberOflines = getNuberOflines(fileName);
        int minArraySize = getMinimalArraySize(fileName);

        if (numberOflines > minArraySize) {
            this.array = new Long[numberOflines][2];
        } else {
            this.array = new Long[minArraySize][2];
        }
    }

    public int getMinimalArraySize(String fileName)throws IOException{
        int hashvalueLength = String.valueOf(getFirstNumberHashvalue(fileName)).length();
        int minArraySize = (int) Math.pow(10,hashvalueLength ) - 1;
        return minArraySize;
    }

    public int getFirstNumberHashvalue(String fileName) throws IOException {
        HashingFunction3 hashingFunction3 = new HashingFunction3();
        int hashValue = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        long line = Long.parseLong(reader.readLine());
        reader.close();
        hashValue = hashingFunction3.getHashValue(line);
        return hashValue;
    }

    public int getNuberOflines(String fileName) throws IOException {
        int lines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }

    public void testInput(String fileName) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String tLine;
        HashingFunction3 hashingFunction3 = new HashingFunction3();

        int i = 0;
        while ((tLine = b.readLine()) != null) {
            Integer hashValue = hashingFunction3.getHashValue(Long.parseLong(tLine));

            i++;
        }
        reader.close();
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
