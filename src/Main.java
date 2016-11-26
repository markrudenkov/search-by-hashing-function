import CollisionRemovingMethod.LinearCollisionRemovingMethod;
import CollisionRemovingMethod.SecondCollisionRemovingMethod;
import HashingFunctions.HashingFunction3;
import HashingFunctions.HashingFunctionModular;
import Utils.InputData;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        InputData inputData = new InputData();
        String filepath = new File(inputData.getFilename()).getAbsolutePath();
        ArrayList<Long> testData = inputData.readData(filepath);
        testData = inputData.trimDataAmount(testData);
        System.out.println("Computing.....");

        // Hashing functions
        HashingFunction3 hashingFunction3 = new HashingFunction3(testData);
        HashingFunctionModular hashingFunctionModular = new HashingFunctionModular(testData);

    /*    // Second Colision removing method
        // hashing function 3
        SecondCollisionRemovingMethod secondCollisionRemovingMethod = new SecondCollisionRemovingMethod(testData, hashingFunction3);
        Statistics statistics = new Statistics(testData, secondCollisionRemovingMethod);

        // Modular hashing function
        SecondCollisionRemovingMethod secondCollisionRemovingMethod2 = new SecondCollisionRemovingMethod(testData, hashingFunctionModular);
        Statistics statistics2 = new Statistics(testData, secondCollisionRemovingMethod2);

        System.out.println("Second Collision Removing Method Coumputation is done");*/

        // Linear Colision removing method
        // hashing function 3
        LinearCollisionRemovingMethod linearCollisionRemovingMethod = new LinearCollisionRemovingMethod(testData, hashingFunction3);
        Statistics statistics3 = new Statistics(testData, linearCollisionRemovingMethod);
        // Modular hashing function
        LinearCollisionRemovingMethod linearCollisionRemovingMethod1 = new LinearCollisionRemovingMethod(testData, hashingFunctionModular);
        Statistics statistics4 = new Statistics(testData, linearCollisionRemovingMethod1);

        System.out.println("Linear Collision Removing Method Coumputation is done");
        System.out.println("Computation is done");
    }
}
