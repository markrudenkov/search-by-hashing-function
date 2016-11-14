package HashingFunctions;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public class PrimeNumber {

    public int getPrimeNumber( int uperRange) {
        int primeNumber = 0;
        int lowerRange = (int)0.5*uperRange;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        int i, j, flag = 0;
        for (i = lowerRange; i <= uperRange; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                } else {
                    flag = 1;
                }


                if (flag == 1) {
                    primeNumbers.add(i);
                }

            }



        }
        primeNumber = Collections.max(primeNumbers).intValue();
        return primeNumber;
    }
}
