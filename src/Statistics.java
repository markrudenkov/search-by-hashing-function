import CollisionRemovingMethod.CollisionMethod;
import HashingFunctions.HashingFunction;
import Utils.FileSave;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Statistics {
    private ArrayList<Long> testData = new ArrayList();
    private ArrayList<Integer> enntryLengths = new ArrayList();
    private ArrayList<Integer> chainLengths = new ArrayList();
    private ArrayList<String> outputData = new ArrayList();

    public Statistics(ArrayList<Long> testData, CollisionMethod colisionMethod) throws Exception {
        this.testData = testData;
        getStatistics(colisionMethod);
    }

    public void getStatistics(CollisionMethod colisionMethod) throws Exception {
        HashingFunction hashingFunction = colisionMethod.getHashingFunction();
        countEntry(colisionMethod, hashingFunction);
        countChains(colisionMethod, hashingFunction);
        double averageEntryLength = getAverageOfList(enntryLengths);
        int maxLength = getMaxOfList(enntryLengths);

        double averageChain = getAverageOfList(chainLengths);
        int maxChain = getMaxOfList(chainLengths);

        FileSave fileSave = new FileSave();
        String statistics = "Statistics: "+"\n"
                +" average amount of etries in hased table " + averageEntryLength + "\n"
                +" maximum amount of etries in hased table " + maxLength + "\n"
                + " average chain lenght " + averageChain + "\n"
                +" maximum chain length " + maxChain+"\n";
        fileSave.saveToTxt("wynik_" + hashingFunction.getName() + "_" + colisionMethod.getName() + ".txt", statistics);
    }

    public void countChains(CollisionMethod colisionMethod, HashingFunction hashingFunction) throws Exception {

        Class myClass = Class.forName(colisionMethod.getClassName());
        Method[] methods = myClass.getMethods();

        for (int i = 0; i < methods.length; ++i) {
            if (methods[i].getName().startsWith("getChainLengts")) {
                chainLengths = (ArrayList<Integer>) methods[i].invoke(colisionMethod, hashingFunction);
            }
        }
    }

    public void countEntry(CollisionMethod colisionMethod, HashingFunction hashingFunction) throws Exception {
        Iterator var5 = this.testData.iterator();

        while (var5.hasNext()) {
            Long testNumber = (Long) var5.next();
            boolean entryLength = false;
            int entryLength1 = this.getEntryLengthWithDefinedColisionRemovingMethod(colisionMethod, testNumber, hashingFunction);
            if (entryLength1 != 0) {
                this.enntryLengths.add(Integer.valueOf(entryLength1));
            }
        }
    }

    public double getAverageOfList(ArrayList<Integer> list) {
        double entryLength = 0.0D;

        Integer chain;
        for (Iterator var3 = list.iterator(); var3.hasNext(); entryLength += (double) chain.intValue()) {
            chain = (Integer) var3.next();
        }

        entryLength /= (double) list.size();
        return entryLength;
    }

    public Integer getMaxOfList(ArrayList<Integer> list) {
        int maxLength1 = ((Integer) Collections.max(list)).intValue();
        return Integer.valueOf(maxLength1);
    }

    public int getEntryLengthWithDefinedColisionRemovingMethod(CollisionMethod colisionMethod, Long number, HashingFunction hashingFunction) throws Exception {
        int entryLength = 0;
        Class myClass = Class.forName(colisionMethod.getClassName());
        Method[] methods = myClass.getMethods();

        for (int i = 0; i < methods.length; ++i) {
            if (methods[i].getName().startsWith("getEntryLenght")) {
                entryLength = (Integer) methods[i].invoke(colisionMethod, number, hashingFunction);
            }
        }
        return entryLength;
    }

    public ArrayList<Long> getTestData() {
        return this.testData;
    }

    public void setTestData(ArrayList<Long> testData) {
        this.testData = testData;
    }

    public ArrayList<Integer> getChainLengths() {
        return chainLengths;
    }
}