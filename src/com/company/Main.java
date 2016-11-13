

package com.company;


import com.company.CollisionRemovingMethod.LinearCollisionRemovingMethod;
import com.company.CollisionRemovingMethod.SecondCollisionRemovingMethod;
import com.company.HashingFunctions.HashingFunction3;
import com.company.HashingFunctions.HashingFunctionModular;

public class Main {


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


    public static <E> void printArray(E[] array) {
        int i = 0;
        Object[] var2 = array;
        int length = array.length;

        for(E element: array) {

            System.out.println("element = " + element  + " hashValue " + i);
            i++;
        }

    }


    public static void main(String[] args) throws Exception {

        System.out.println("Computing.....");
        String filepath = "C:\\Users\\Jan Nachtigal\\Desktop\\e\\V semesrtr\\Algorytmy is truktury danych\\dziesieckilo.txt";

        HashingFunction3 hashingFunction3 = new HashingFunction3(2.0E-7D, 10000);
        HashingFunctionModular hashingFunctionModular = new HashingFunctionModular(100,filepath);

       SecondCollisionRemovingMethod secondCollisionRemovingMethod = new SecondCollisionRemovingMethod();
        secondCollisionRemovingMethod.createDataArrayAndInputNUmbers(filepath, hashingFunction3);

        SecondCollisionRemovingMethod secondCollisionRemovingMethod2 = new SecondCollisionRemovingMethod();
        secondCollisionRemovingMethod2.createDataArrayAndInputNUmbers(filepath,hashingFunctionModular);

        Statistics statistics = new Statistics();
        statistics.getStatistics(filepath, secondCollisionRemovingMethod, hashingFunction3);

        Statistics statistics2 = new Statistics();
        statistics2.getStatistics(filepath, secondCollisionRemovingMethod2,hashingFunctionModular);

        System.out.println("Second Collision Removing Method Coumputation ended");

        // Linear Colision removing method

        // hashing function 3
        LinearCollisionRemovingMethod linearCollisionRemovingMethod = new LinearCollisionRemovingMethod();
        linearCollisionRemovingMethod.createDataArrayAndInputNUmbers(filepath,hashingFunction3);

        Statistics statistics3 = new Statistics();
        statistics3.getStatistics(filepath, linearCollisionRemovingMethod,hashingFunction3);

        // Modular hashing function
        LinearCollisionRemovingMethod linearCollisionRemovingMethod1 = new LinearCollisionRemovingMethod();
        linearCollisionRemovingMethod1.createDataArrayAndInputNUmbers(filepath,hashingFunctionModular);

        Statistics statistics4 = new Statistics();
        statistics4.getStatistics(filepath,linearCollisionRemovingMethod,hashingFunctionModular);

        System.out.println("Linear Collision Removing Method Coumputation ended");


    }
}
