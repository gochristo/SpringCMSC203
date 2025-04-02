/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Methods to potentially be used for calculating holiday bonus from a 2d array
 * Due: 04/02/2025
 * Platform/compiler: IntelliJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Christopher Andrews
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<double[]> arr = new ArrayList<double[]>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] token = line.split(" ");
            double[] row = new double[token.length];

            for (int j = 0; j < token.length; j++) {
                row[j] = Double.parseDouble(token[j]);
            }

            arr.add(row);
        }

        scanner.close();
        if(arr.isEmpty()){
            return null;
        }else {
            return arr.toArray(new double[arr.size()][]);
        }
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);

        for (int i = 0; i < data.length; i++) {
            String line = "";

            for (int j = 0; j < data[i].length; j++) {
                line += data[i][j] + " ";
            }

            pw.println(line);
        }
        pw.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    public static double getRowTotal(double[][] data, int row) {
        double rowTotal = 0.0;
        for (int i = 0; i < data[row].length; i++) {
            rowTotal += data[row][i];
        }
        return rowTotal;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int lowestIndex = 0;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < data[row][lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double LowestInRow = data[row][0];
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < LowestInRow) {
                LowestInRow = data[row][i];
            }
        }
        return LowestInRow;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        int lowestIndex = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > col && data[i][col] < data[lowestIndex][col]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double LowestInColumn = data[0][col];
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > col && data[i][col] < LowestInColumn) {
                LowestInColumn = data[i][col];
            }
        }
        return LowestInColumn;
    }

    public static double getLowestInArray(double[][] data) {
        double LowestInArray = data[0][0];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < LowestInArray) {
                    LowestInArray = data[i][j];
                }
            }
        }
        return LowestInArray;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int highestIndex = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[row][i] > data[row][highestIndex]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double HighestInRow = data[row][0];
        for (int i = 0; i < data.length; i++) {
            if (data[row][i] > HighestInRow) {
                HighestInRow = data[row][i];
            }
        }
        return HighestInRow;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        int highestIndex = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i].length > col && data[i][col] > data[highestIndex][col]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double highestInColumn = data[0][col];
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > col && data[i][col] > highestInColumn) {
                highestInColumn = data[i][col];
            }
        }
        return highestInColumn;
    }

    public static double getHighestInArray(double[][] data) {
        double HighestInArray = data[0][0];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > HighestInArray) {
                    HighestInArray = data[i][j];
                }
            }
        }
        return HighestInArray;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double columnTotal = 0.0;
        for (int i = 0; i < data.length; i++) {
            if(data[i].length > col){
                columnTotal += data[i][col];
            }
        }
        return columnTotal;
    }

    public static double getAverage(double[][] data) {
        double average = 0.0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                average += data[i][j];
                count++;
            }
        }
        average /= count;
        return average;
    }




}
