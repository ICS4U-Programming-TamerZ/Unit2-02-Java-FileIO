package com.example;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads numbers from an input file, calculates the sum of each line,
 * and writes the sums or error messages to an output file.
 *
 * @author Tamer Zreg
 * @version 1.0
 * @since 2024-03-26
 */
public final class FileIO {

    /** This is a private constructor used to prevent instantiation. */
    private FileIO() {
        throw new UnsupportedOperationException("Cannot be instantiated.");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        String inputFilePath = "./input.txt"; // Path to input file
        String outputFilePath = "./output.txt"; // Path to output file

        try {
            // Open input and output files
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);
            PrintWriter writer = new PrintWriter(outputFile);
            Scanner fileScanner = new Scanner(inputFile);

            // Process each line of the input file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] arrOfStr = line.split(" ");
                int sum = 0;
                boolean error = false;

                // Calculate sum of numbers in the line
                for (String numberAsString : arrOfStr) {
                    try {
                        int numberAsInt = Integer.parseInt(numberAsString);
                        sum += numberAsInt;
                    } catch (NumberFormatException e) {
                        // If parsing fails, set error flag and break
                        error = true;
                        System.out.println("Error: " + e.getMessage());
                        break;
                    }
                }

                // Write sum or error message to output file
                if (!error) {
                    writer.println(sum);
                } else {
                    writer.println("Error occurred in input line: " + line);
                }
            }

            // Close resources
            fileScanner.close();
            writer.close();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
