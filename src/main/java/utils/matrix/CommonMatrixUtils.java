package utils.matrix;

import java.util.ArrayList;

/*Common matrix util methods*/
public class CommonMatrixUtils {

    public static boolean[][] convertToBooleanMatrix(ArrayList<ArrayList<Integer>> matrix){
        int matrixSize = matrix.size();
        //convert to boolean
        boolean[][] boolMatrix = new boolean[matrixSize][matrixSize];
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                boolMatrix[i][j] = matrix.get(i).get(j) != 0;
            }
        }
        return boolMatrix;
    }

    public static ArrayList<ArrayList<Integer>> convertToRealMatrix(boolean[][] booleanMatrix){
        int matrixSize = booleanMatrix.length;
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();
        ArrayList<Integer> line;
        for(int i=0; i<matrixSize; i++){
            line = new ArrayList<>();
            for(int j=0; j<matrixSize; j++){
                if(booleanMatrix[i][j]){
                    line.add(new Integer(1));
                } else {
                    line.add(new Integer(0));
                }
            }
            resultMatrix.add(line);
        }
        return resultMatrix;
    }

    public static boolean[][] multipleBoolMatrix(boolean[][] booleanMatrix1, boolean[][] booleanMatrix2){
        int matrixSize = booleanMatrix1.length;
        boolean[][] boolMatrixResult = new boolean[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    if (booleanMatrix1[i][k] && booleanMatrix2[k][j]) {
                        boolMatrixResult[i][j] = true;
                    }
                }
            }
        }
        return boolMatrixResult;
    }

    public static boolean[][] powerBoolMatrix(boolean[][] matrix, int power){
        boolean[][] boolMatrixResult = matrix;
        if(power == 1){
            return matrix;
        }
        for(int i = 2; i<=power; i++){
            boolMatrixResult = CommonMatrixUtils.multipleBoolMatrix(boolMatrixResult, matrix);
        }
        return boolMatrixResult;
    }

    //TODO refactor with StringBuilder
    public static String matrixToString(ArrayList<ArrayList<Integer>> matrix){
        int matrixSize = matrix.size();
//        String result = "<html>";
        String result = "";
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                result += matrix.get(i).get(j) + " ";
            }
            result += "<br>";
        }
        //result += "</html>";
        return result;
    }
}
