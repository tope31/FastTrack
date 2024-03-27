package dayOneHomework;

import java.util.Random;

public class TableGenerator {
    public String generateRandomCharacters() {
        int characterCount = 3;
        Random random = new Random();
        StringBuilder result = new StringBuilder(characterCount);
        final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final String digits = "0123456789";
        final String symbols = "!@#$%^&*()_+{}[]|;'<>";
        final String alphaNumeric = letters + digits + symbols;

        for (int i = 0; i < characterCount; i++) {
            int randomIndex = random.nextInt(alphaNumeric.length());
            result.append(alphaNumeric.charAt(randomIndex));
        }
        return result.toString();
    }

    public String[][] generateTable(String userInput) {
        //retrieve row and column provided by user
        int row = Character.getNumericValue(userInput.charAt(0));
        int column = Character.getNumericValue((userInput.charAt(userInput.length() - 1)));

        String[][] table = new String[row][column];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = generateRandomCharacters();
            }
        }
        return table;
    }

    public void printTable(String[][] generatedTable) {
        for (String[] arrElement : generatedTable) {
            for (String element : arrElement) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String[][] editTable(String[][] generatedTable, String editDimensionLocation, String updatedDimensionValue) {
        int row = Character.getNumericValue(editDimensionLocation.charAt(0));
        int column = Character.getNumericValue((editDimensionLocation.charAt(editDimensionLocation.length() - 1)));
        generatedTable[row][column] = updatedDimensionValue;
        return generatedTable;
    }

    public void retrieveIndexAndOccurrence(String[][] generatedTable, String userSearch) {
        int charCount = 0;
        for (int i = 0; i < generatedTable.length; i++) {
            for (int j = 0; j < generatedTable[i].length; j++) {
                String currentString = generatedTable[i][j];
                if (currentString.contains(userSearch)) {
                    for (int k = 0; k < currentString.length(); k++) {
                        if (String.valueOf(currentString.charAt(k)).equals(userSearch)) {
                            charCount++;
                        }
                    }
                    System.out.println("[" + i + "," + j + "]" + " - " + charCount + " occurrence");
                }
            }
        } if (charCount == 0) {
            System.out.println("No occurrence in the table");
        }
    }
}
