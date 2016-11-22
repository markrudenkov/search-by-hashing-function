




import CollisionRemovingMethod.LinearCollisionRemovingMethod;
import CollisionRemovingMethod.SecondCollisionRemovingMethod;
import HashingFunctions.HashingFunction3;
import HashingFunctions.HashingFunctionModular;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Computing.....");
        String filepath = new File("milionliczb.txt").getAbsolutePath();

        // Hashing functions
        HashingFunction3 hashingFunction3 = new HashingFunction3(filepath);
        HashingFunctionModular hashingFunctionModular = new HashingFunctionModular(filepath);

        // Second Colision removing method
        
            // hashing function 3
        SecondCollisionRemovingMethod secondCollisionRemovingMethod = new SecondCollisionRemovingMethod(filepath,hashingFunction3);

        Statistics statistics = new Statistics(filepath,secondCollisionRemovingMethod);

        // Modular hashing function

       // SecondCollisionRemovingMethod secondCollisionRemovingMethod2 = new SecondCollisionRemovingMethod(filepath, hashingFunctionModular);

       // Statistics statistics2 = new Statistics(filepath,secondCollisionRemovingMethod2);

       System.out.println("Second Collision Removing Method Coumputation is done");

        // Linear Colision removing method

            // hashing function 3
       /*LinearCollisionRemovingMethod linearCollisionRemovingMethod = new LinearCollisionRemovingMethod(filepath,hashingFunction3);

        Statistics statistics3 = new Statistics(filepath, linearCollisionRemovingMethod);*/


             // Modular hashing function
/*        LinearCollisionRemovingMethod linearCollisionRemovingMethod1 = new LinearCollisionRemovingMethod(filepath,hashingFunctionModular);

        Statistics statistics4 = new Statistics(filepath, linearCollisionRemovingMethod1);*/

        System.out.println("Linear Collision Removing Method Coumputation is done");


        System.out.println("Computation is done");

    }

}
