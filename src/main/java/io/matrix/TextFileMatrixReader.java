package io.matrix;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileMatrixReader implements FileMatrixReader {

    public ArrayList<ArrayList<Integer>> readMatrixFromFile(File inputFile) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> line = new ArrayList<>();
        try (Scanner reader = new Scanner(new FileReader(inputFile))){
            //parse file
            while (reader.hasNext()) {
                Scanner lineReader = new Scanner(reader.nextLine());
                while (lineReader.hasNext()) {
                    String currentItem = lineReader.next();
                    if (currentItem != " ") {
                        Integer currInt = Integer.valueOf(currentItem);
                        line.add(currInt);
                    }
                }
                lineReader.close();
                matrix.add(line);
                line = new ArrayList<>();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return matrix;
    }
}
