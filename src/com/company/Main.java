//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;


import com.company.CollisionRemovingMethod.SecondCollisionRemovingMethod;
import com.company.HashingFunctions.HashingFunction3;

public class Main {


    public static void main(String[] args) throws Exception {
        String filepath = "C:\\Users\\Jan Nachtigal\\Desktop\\e\\V semesrtr\\Algorytmy is truktury danych\\dziesieckilo.txt";
        HashingFunction3 hashingFunction3 = new HashingFunction3(2.0E-7D, 10000);

        SecondCollisionRemovingMethod secondCollisionRemovingMethod = new SecondCollisionRemovingMethod();
        secondCollisionRemovingMethod.createDataArrayAndInputNUmbers(filepath, hashingFunction3);

        Statistics statistics = new Statistics();
        statistics.getStatistics(filepath, secondCollisionRemovingMethod, hashingFunction3);


        System.out.println("Coumputation ended");
    }
}
