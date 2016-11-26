package Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class InputData extends FileReader {
    public String getFilename() {
        System.out.print("Enter filename witout apostrophes ex. 'testdata.txt' : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public int getDataSize() {
        System.out.print("Enter amount of number to analysis from your test data ex. 1000 if you want to analyse whole dataset press 0: ");
        Scanner scanner = new Scanner(System.in);
        int dataLength = Integer.parseInt(scanner.nextLine());
        return dataLength;
    }

    public ArrayList<Long> trimDataAmount(ArrayList<Long> testData) {
        ArrayList<Long> trimedList = new ArrayList<>();
        int dataLength = this.getDataSize();
        if (dataLength != 0) {
            for (int i = 0; i < dataLength; i++) {
                trimedList.add(testData.get(i));
            }
            testData = trimedList;
        }
        return testData;
    }
}
