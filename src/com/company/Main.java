//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;


import com.company.CollisionRemovingMethod.SecondCollisionRemovingMethod;
import com.company.HashingFunctions.HashingFunction3;

public class Main {


    public static void main(String[] args) throws Exception {
        HashingFunction3 hashingFunction3 = new HashingFunction3(2.0E-7D, 10000);
        String filepath = "C:\\Users\\Jan Nachtigal\\Desktop\\e\\V semesrtr\\Algorytmy is truktury danych\\dziesieckilo.txt";

        SecondCollisionRemovingMethod secondCollisionRemovingMethod = new SecondCollisionRemovingMethod();
        Statistics statistics = new Statistics();
        secondCollisionRemovingMethod.createDataArrayAndInputNUmbers(filepath, hashingFunction3);
        statistics.getStatistics(filepath, secondCollisionRemovingMethod, hashingFunction3);
    }
}
