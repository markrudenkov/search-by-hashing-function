package HashingFunctions;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public class PrimeNumber {

    public int getPrimeNumber( int uperRange) {
        int primeNumber = 0;
        int lowerRange = (int)0.9*uperRange;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        int i;
        int  j, flag = 1;
        for (i = uperRange; i >=0; i--) {
            flag = 1;

            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }



                if (flag == 1) {
                    primeNumber=i;
                    break;
                }





        }
        //primeNumber = Collections.max(primeNumbers).intValue();
        return primeNumber;
    }
}
