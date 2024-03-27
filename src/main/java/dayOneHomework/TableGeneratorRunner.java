package dayOneHomework;

import java.util.Scanner;

public class TableGeneratorRunner {
    public static void main(String[] args) {
        TableGenerator tblGen = new TableGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Table Dimensions: ");
        String tableDimension = scanner.nextLine();
        String[][] generatedTable = tblGen.generateTable(tableDimension);
        boolean appIsRunning = true;

        while (appIsRunning) {
            System.out.println();
            tblGen.printTable(generatedTable);

            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("S to Search\nE to Edit\nR to Reset");
            System.out.print("Operation: ");
            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "S":
                    System.out.println("Search operation selected!");
                    // Code for Search functionality
                    System.out.print("Search: ");
                    String userSearch = scanner.nextLine();
                    System.out.println("Searching for element " + userSearch + " in the generated table");
                    tblGen.retrieveIndexAndOccurrence(generatedTable, userSearch);
                    break;
                case "E":
                    System.out.println("Edit operation selected!");
                    System.out.print("Edit: ");
                    String editValue = scanner.nextLine();
                    System.out.print("Input New Dimension Value: ");
                    String updatedDimensionValue = scanner.nextLine();
                    generatedTable = tblGen.editTable(generatedTable, editValue, updatedDimensionValue);
                    break;
                case "R":
                    System.out.println("Reset operation selected!");
                    System.out.print("Input new table dimensions: ");
                    String tableDimensions = scanner.nextLine();
                    generatedTable = tblGen.generateTable(tableDimensions);
                    break;
                case "Q":
                    appIsRunning = false;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }
    }
}