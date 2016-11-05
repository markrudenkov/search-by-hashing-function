package com.company;

import java.io.IOException;

public class Main {




    public static boolean compare(Long[][] array) {

        if (array[0][0] == null) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        SecondCollisionRemovingMethod foo = new SecondCollisionRemovingMethod();
        foo.createDataArray("C:\\Users\\Jan Nachtigal\\Desktop\\e\\V semesrtr\\Algorytmy is truktury danych\\dziesiecliczb.txt");
        //foo.createDataArray("E:\\V semesrtr\\Algorytmy is truktury danych\\dziesiecliczb.txt");
        //foo.inputDataToArray("E:\\V semesrtr\\Algorytmy is truktury danych\\dziesiecliczb.txt");

        HashingFunction3 hashingFunction3 = new HashingFunction3();
        Integer hashValue = hashingFunction3.getHashValue(Long.parseLong("123409403039"));
        foo.inputDataToArray("C:\\Users\\Jan Nachtigal\\Desktop\\e\\V semesrtr\\Algorytmy is truktury danych\\dziesiecliczb.txt");
        System.out.println(hashValue);


}
}
