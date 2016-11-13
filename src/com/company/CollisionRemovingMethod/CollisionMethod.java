package com.company.CollisionRemovingMethod;

import com.company.HashingFunctions.HashingFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class CollisionMethod {




    public abstract String getClassName();
    public abstract String getName();
    public abstract int getChainlenght(Long number,HashingFunction hashingFunction) throws Exception;

    public abstract void inputDataToArray(String fileName, HashingFunction hashingFunction) throws Exception;
    public abstract void createDataArrayAndInputNUmbers(String fileName, HashingFunction hashingFunction) throws Exception;

    public int getNuberOflines(String fileName) throws IOException {
        int lines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
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




  /*  public int getIndexLastEmptyElement(int index) {
        int indexLastEmptyElement = 0;
        for (int i = index; i > 0; i--) {
            if (checkIfEmptyNumberElement(i)) {
                indexLastEmptyElement = i;
                break;
            }
        }
        return indexLastEmptyElement;
    }*/



    public int getMinimalArraySize(String fileName, HashingFunction hashingFunction)throws IOException{
        int hashvalueLength = String.valueOf(getFirstNumberHashvalue(fileName, hashingFunction)).length();
        int minArraySize = (int) Math.pow(10,hashvalueLength ) - 1;
        return minArraySize;
    }

    public int getFirstNumberHashvalue(String fileName, HashingFunction hashingFunction) throws IOException {
        int hashValue = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        long line = Long.parseLong(reader.readLine());
        reader.close();
        hashValue = hashingFunction.getHashValue(line);
        return hashValue;
    }


}
