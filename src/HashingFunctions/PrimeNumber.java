package HashingFunctions;

public class PrimeNumber {

    public int getPrimeNumber(int uperRange) {
        int primeNumber = 0;
        int i;
        int j, flag;
        for (i = uperRange; i >= 0; i--) {
            flag = 1;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                primeNumber = i;
                break;
            }
        }
        return primeNumber;
    }
}
