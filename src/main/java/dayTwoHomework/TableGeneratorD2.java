package dayTwoHomework;

import java.util.*;

public class TableGeneratorD2 {
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

    public String[][] generateTable(String tableDimensions) {
        int row = Character.getNumericValue(tableDimensions.charAt(0));
        int column = Character.getNumericValue((tableDimensions.charAt(tableDimensions.length() - 1)));

        String[][] table = new String[row][column];

        for (int i = 0; i < table.length ; i++) {
            for (int j = 0; j < table[i].length; j++) {
                String key = generateRandomCharacters();
                String value = generateRandomCharacters();
                String keyValueResult = key + "," + value;
                table[i][j] = keyValueResult;
            }
        }
        return table;
    }

    public void printTable(String[][] generatedTable) {
        for (String[] arrElement: generatedTable) {
            for (String element: arrElement) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void retrieveIndexAndOccurrence(String[][] generatedTable, String cell) {
        int charCount = 0;
        for (int i = 0; i < generatedTable.length; i++) {
            for (int j = 0; j < generatedTable[i].length; j++) {
                String currentString = generatedTable[i][j];
                if (currentString.contains(cell)) {
                    for (int k = 0; k < currentString.length(); k++) {
                        if (String.valueOf(currentString.charAt(k)).equals(cell)) {
                            charCount++;
                        }
                    }
                    System.out.println("[" + i + "," + j + "]" + " - " + charCount + " occurrence found on value field");
                }
            }
        }
        if (charCount == 0) {
            System.out.println("No such element found");
        }
    }

    public String[][] editTable(String[][] generatedTable, String editValue, String keyValueChoice, String updatedDimensionValue) {
        //retrieve row and column provided by user
        String keyValueResult = "";
        int row = Character.getNumericValue(editValue.charAt(0));
        int column = Character.getNumericValue((editValue.charAt(editValue.length() - 1)));
        if (keyValueChoice.equalsIgnoreCase("k")) {
            String key = generatedTable[row][column].substring(0, 3);
            String updatedKey = key.replace(key, updatedDimensionValue);
            keyValueResult = updatedKey + generatedTable[row][column].substring(3);
        } else if (keyValueChoice.equalsIgnoreCase("v")) {
            String value = generatedTable[row][column].substring(4);
            String updatedValue = value.replace(value, updatedDimensionValue);
            keyValueResult = generatedTable[row][column].substring(0,4) + updatedValue;
            System.out.println(keyValueResult);
        } else if (keyValueChoice.equalsIgnoreCase("kv")) {
            keyValueResult = generatedTable[row][column].replace(generatedTable[row][column], updatedDimensionValue);
            System.out.println(keyValueResult);
        }
        generatedTable[row][column] = keyValueResult;
        return generatedTable;
    }

    public String[][] sortArrayInAscendingOrder(String[][] generatedTable) {
        List<String> arrList = new ArrayList<>();
        for (String[] element: generatedTable) {
            arrList.addAll(Arrays.asList(element));
        }

        arrList.sort(Comparator.naturalOrder());

        String[][] ascendingArray = new String[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ascendingArray[i][j] = arrList.get(index);
                index++;
            }
        }
        return ascendingArray;
    }

    public String[][] sortArrayInDescendingOrder(String[][] generatedTable) {
        List<String> arrList = new ArrayList<>();
        for (String[] element: generatedTable) {
            arrList.addAll(Arrays.asList(element));
        }

        arrList.sort(Comparator.reverseOrder());

        String[][] descendingArray = new String[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                descendingArray[i][j] = arrList.get(index);
                index++;
            }
        }
        return descendingArray;
    }


    public String[][] addDynamicValueBasedOnUserRowChoice(String[][] generatedTable, int userRowChoice) {
        int row = generatedTable.length;
        int column = generatedTable[0].length;

        String[][] newGeneratedTable = new String[row][column + 1];

        for (int i = 0; i < row; i++) {
            System.arraycopy(generatedTable[i], 0, newGeneratedTable[i], 0, column);
        }

        newGeneratedTable[userRowChoice][column] = generateRandomCharacters() + "," + generateRandomCharacters();
        return newGeneratedTable;
    }

}
