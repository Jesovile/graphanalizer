package io.matrix;

import java.io.File;
import java.util.ArrayList;

public interface FileMatrixReader {
    ArrayList<ArrayList<Integer>> readMatrixFromFile(File inputFile);
}
