package dayTwoHomework.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileExport {
    public void persistTableValuesIntoFile(String[][] generatedTable) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("TableValues.txt", false));
        for (String[] s : generatedTable) {
            writer.write(String.join("\t", s));
            writer.newLine();
        }
        writer.flush();
        System.out.println("Data Entered in to the file successfully");
    }

    public String[][] readValuesFromFile() throws IOException {
        List<String> strList = new ArrayList<>();
        BufferedReader bf = new BufferedReader(
                new FileReader("TableValues.txt"));
        String line = bf.readLine();
        int row = 0;
        int column;

        while (line != null) {
            strList.addAll(List.of(line.split("\t")));
            line = bf.readLine();
            row++;
        }

        column = strList.size() / row;

        String[][] sortedTestList = new String[row][column];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sortedTestList[i][j] = strList.get(index);
                index++;
            }
        }
        return sortedTestList;
    }

}
