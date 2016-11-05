package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class SecondCollisionRemovingMethod {

    HashingFunction3 hashingFunction3 = new HashingFunction3();
    Long[][] array; // array[x][0] - number element; array[x][1] - pointer element


    public void createDataArrayAndInputNUmbers() throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wprowadz nazwe pliku i cisnij enter Enter:");
        String fileName = b.readLine();
        getNuberOflines(fileName);
        createDataArray(fileName);
        inputDataToArray(fileName);

    }


    public void inputDataToArray(String fileName) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        //int i = 0;
        while ((line = reader.readLine()) != null) {
            int hashValue = hashingFunction3.getHashValue(Long.parseLong(line));

            if (checkIfEmptyNumberElement(hashValue)) {
                this.array[hashValue][0] = Long.parseLong(line);
            } else {
                Integer indexOfPredecessorOfLastChainElement = getChainElementWithEmptyPointer(hashValue);
                Integer indexOfNewChainELement = getIndexLastEmptyElement();
                this.array[indexOfNewChainELement][0] = Long.parseLong(line);
                this.array[indexOfPredecessorOfLastChainElement][1] = indexOfNewChainELement.longValue();
            }

            //i++;
        }
        reader.close();
    }


    public int getChainElementWithEmptyPointer(int hashValue) {
        Integer pointer = this.array[hashValue][1].intValue();
        int currentHashValue = hashValue;

        while (pointer != null) {
            currentHashValue = this.array[pointer][0].intValue();
            pointer = this.array[currentHashValue][1].intValue();
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

    public void createDataArray(String fileName) throws IOException {
        this.array = new Long[getNuberOflines(fileName)][2];

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
}
