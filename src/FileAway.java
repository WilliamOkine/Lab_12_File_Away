import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

    public class FileAway {
        public static void main(String[] args) {
            JFileChooser fileChooser = new JFileChooser();

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                processFile(selectedFile);
            }
        }

        private static void processFile(File file) {
            int numLines = 0;
            int numWords = 0;
            int numChars = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    numLines++;
                    numChars += line.length();

                    // Counting words using split() method
                    String[] words = line.split("\\s+");
                    numWords += words.length;
                }

                System.out.println("File Summary Report:");
                System.out.println("File Name: " + file.getName());
                System.out.println("Number of Lines: " + numLines);
                System.out.println("Number of Words: " + numWords);
                System.out.println("Number of Characters: " + numChars);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
    }


