package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSave {
    public String searchDataToString(int hashValue, Long searchableNumber, Long foundNumber) {
        String searchData = null;
        searchData = "hashvalue " + hashValue + " searchable number " + searchableNumber + " found number " + foundNumber;
        return searchData;
    }

    public void saveToTxt(String fileName, String line) throws IOException {
        PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(
                fileName, true)));
        fileWriter.println(line);
        fileWriter.close();
    }

    public void saveStatistics(double averageEntryLength,
                               int maxLength,
                               double averageChain,
                               int maxChain,
                               String functionName,
                               String colissionRemovingMethod) throws IOException {

        String statistics = "Statistics: " + "\n"
                + " average amount of etries in hased table " + averageEntryLength + "\n"
                + " maximum amount of etries in hased table " + maxLength + "\n"
                + " average chain lenght " + averageChain + "\n"
                + " maximum chain length " + maxChain + "\n";
        saveToTxt("wynik_" + functionName + "_" + colissionRemovingMethod + ".txt", statistics);

    }
}
