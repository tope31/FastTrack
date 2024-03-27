package dayTwoHomework;

import dayTwoHomework.util.FileExport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TableGeneratorRunnerD2 {
    public static void main(String[] args) throws IOException {
        TableGeneratorD2 tblGeneratorV2 = new TableGeneratorD2();
        FileExport fileExport = new FileExport();
        Scanner scanner = new Scanner(System.in);
        String choice;
        String fileChoice;
        boolean appIsRunning = true;
        String tableDimensions = "";
        String[][] generatedTable = new String[0][];
        String cell;
        String keyValueChoice;
        String updatedDimensionValue;
        String sortChoice;
        int userRowChoice;

        System.out.println("Table Dimensions Generator \n ");
        Path path = Path.of("TableValues.txt");
        boolean fileExists = Files.exists(path);

        if (fileExists) {
            System.out.println("Table data exists, would you like to load it? (Y/N) ");
            fileChoice = scanner.nextLine().toUpperCase();
            switch (fileChoice) {
                case "Y":
                    generatedTable =  fileExport.readValuesFromFile();
                    System.out.println("hi");
                    break;
                case "N":
                    break;
            }
        }

        while (appIsRunning) {
            System.out.println("Select an Operation");
            System.out.println("""
                    G to Generate Table
                    P to Print Table
                    S to Search
                    E to Edit
                    R to Reset
                    SR to Sort
                    AD to Add Column
                    SV to Save Table Data
                    Q to Quit Program
                    """);
            System.out.print("Operation: ");
            choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "G":
                    System.out.print("Input Table Dimensions: ");
                    tableDimensions = scanner.nextLine();
                    generatedTable = tblGeneratorV2.generateTable(tableDimensions);
                    System.out.println();
                    System.out.println("Table with " + tableDimensions + " dimensions has been created.");
                    System.out.println();
                    break;
                case "P":
                    System.out.println();
                    tblGeneratorV2.printTable(generatedTable);
                    break;
                case "S":
                    System.out.print("Search: ");
                    cell = scanner.nextLine();
                    System.out.println("Searching for element " + cell + " in the generated table");
                    tblGeneratorV2.retrieveIndexAndOccurrence(generatedTable, cell);
                    System.out.println();
                    break;
                case "E":
                    System.out.print("Input Cell Value: ");
                    String editValue = scanner.nextLine();
                    System.out.print("Key or Value?\nK for Key\nV for Value\nKV for both Key and Value\n");
                    System.out.print("Operation: ");
                    keyValueChoice = scanner.nextLine();
                    System.out.print("Input New Dimension Value: ");
                    updatedDimensionValue = scanner.nextLine();
                    generatedTable = tblGeneratorV2.editTable(generatedTable, editValue, keyValueChoice, updatedDimensionValue);
                    System.out.println("Cell " + editValue + " has been updated successfully.");
                    System.out.println();
                    break;
                case "R":
                    System.out.print("Input New Dimension Value: ");
                    updatedDimensionValue = scanner.nextLine();
                    generatedTable = tblGeneratorV2.generateTable(updatedDimensionValue);
                    System.out.println("Table with dimensions " + updatedDimensionValue + " has been generated");
                    System.out.println();
                    break;
                case "SR":
                    System.out.print("A for Ascending\nD for Descending\n");
                    System.out.print("Operation: ");
                    sortChoice = scanner.nextLine();
                    if (sortChoice.equalsIgnoreCase("A")) {
                        generatedTable = tblGeneratorV2.sortArrayInAscendingOrder(generatedTable);
                        System.out.println("\nTable has been sorted in Ascending Order\n");
                    } else if (sortChoice.equalsIgnoreCase("D")) {
                        generatedTable = tblGeneratorV2.sortArrayInDescendingOrder(generatedTable);
                        System.out.println("\nTable has been sorted in Descending Order\n");
                    } else {
                        System.out.println("Invalid Operation");
                    }
                    break;
                case "AD":
                    System.out.print("Input Row: ");
                    userRowChoice = scanner.nextInt();
                    scanner.nextLine();

                    generatedTable = tblGeneratorV2.addDynamicValueBasedOnUserRowChoice(generatedTable, userRowChoice);
                    break;
                case "SV":
                    fileExport.persistTableValuesIntoFile(generatedTable);
                case "Q":
                    appIsRunning = false;
                    break;
                default:
                    System.out.println("Invalid operation.\n");
            }
        }
    }
}

