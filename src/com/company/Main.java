//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import com.company.HashingFunction3;
import com.company.SecondCollisionRemovingMethod;
import com.company.Statistics;

public class Main {
    public Main() {
    }

    public static <E> void printArray(E[][] array) {
        int i = 0;
        Object[][] var2 = array;
        int var3 = array.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object[] element = var2[var4];
            System.out.println("element = " + element[0] + " hashvalue =" + element[1] + " hashValue " + i);
            ++i;
        }

    }

    public static boolean compare(Long[][] array) {
        return array[0][0] == null;
    }

    public static void main(String[] args) throws Exception {
        HashingFunction3 hashingFunction3 = new HashingFunction3(2.0E-7D, 10000);
        String filepath = "C:\\Users\\Jan Nachtigal\\Desktop\\e\\V semesrtr\\Algorytmy is truktury danych\\dziesieckilo.txt";
        SecondCollisionRemovingMethod foo = new SecondCollisionRemovingMethod();
        Statistics statistics = new Statistics();
        foo.createDataArrayAndInputNUmbers(filepath, hashingFunction3.getHashingFunction3());
        statistics.getStatistics(filepath, foo.getSecondColissionRemovingMethod(), foo, hashingFunction3.getHashingFunction3());
    }
}
