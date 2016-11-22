package Utils;

/**
 * Created by kosciuszko on 16.11.22.
 */
public class printArray {

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

    public static <E> void printArray(int[] array) {
        int i = 0;

        int length = array.length;

        for(int element: array) {

            System.out.println("element = " + element  + " hashValue " + i);
            i++;
        }

    }
}
