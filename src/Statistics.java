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
    private ArrayList<Integer> chainLengths = new ArrayList();
    private ArrayList<String> outputData = new ArrayList();



    public void getStatistics(String filename, CollisionMethod colisionMethod, HashingFunction hashingFunction ) throws Exception {
        countChains(filename, colisionMethod, hashingFunction);
        double averageChain = this.getAverageChain();
        int maxchain = this.getMaxChain().intValue();
        FileSave fileSave = new FileSave();
        String statistics = "Statistics: average chain lenght " + averageChain + "; max chain length " + maxchain;
        fileSave.saveToTxt("wynik_"+hashingFunction.getName()+"_"+colisionMethod.getName() +".txt", statistics);
    }

    public double getAverageChain() {
        double averageChain = 0.0D;

        Integer chain;
        for(Iterator var3 = this.chainLengths.iterator(); var3.hasNext(); averageChain += (double)chain.intValue()) {
            chain = (Integer)var3.next();
        }

        averageChain /= (double)this.chainLengths.size();
        return averageChain;
    }

    public Integer getMaxChain() {
        boolean maxChain = false;
        int maxChain1 = ((Integer) Collections.max(this.chainLengths)).intValue();
        return Integer.valueOf(maxChain1);
    }

    public void countChains(String filename, CollisionMethod colisionMethod, HashingFunction hashingFunction) throws Exception {
        this.getTestData(filename);
        Iterator var5 = this.testData.iterator();

        while(var5.hasNext()) {
            Long testNumber = (Long)var5.next();
            boolean chainLength = false;
            int chainLength1 = this.getChainLengthWithDefinedColisionRemovingMethod(colisionMethod, testNumber, hashingFunction);
            if(chainLength1 != 0) {
                this.chainLengths.add(Integer.valueOf(chainLength1));
            }
        }

    }

    public int getChainLengthWithDefinedColisionRemovingMethod(CollisionMethod colisionMethod, Long number, HashingFunction hashingFunction) throws Exception {
        int chainLength = 0;
        Class myClass = Class.forName(colisionMethod.getClassName());
        Method[] methods = myClass.getMethods();
        //Object obj = object;

        for(int i = 0; i < methods.length; ++i) {
            if(methods[i].getName().startsWith("getChainlenght")) {
                chainLength = (Integer) methods[i].invoke(colisionMethod, number, hashingFunction);
            }
        }

        return chainLength;
    }

    public void getTestData(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;

        while((line = reader.readLine()) != null) {
            this.testData.add(Long.valueOf(Long.parseLong(line)));
        }

    }

    public ArrayList<Long> getTestData() {
        return this.testData;
    }

    public void setTestData(ArrayList<Long> testData) {
        this.testData = testData;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             