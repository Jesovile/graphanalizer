package algoritms;

import utils.matrix.CommonMatrixUtils;

public class CommonAlgorithms {

    //TODO refactor with message builder (algorithm haven't to create a result message
    public static String cycleAnalize(boolean[][][] reachabilityTensor){
        int tensorSize = reachabilityTensor.length;
        int cycleCounter;

        String resultMessage = "<html>";
        for(int i = 0; i<tensorSize; i++) {
            //counting
            cycleCounter = 0;
            boolean[][] resultMatrix = reachabilityTensor[i];
            //analyze
            for (int j = 0; j < tensorSize; j++) {
                if (resultMatrix[j][j]) {
                    ++cycleCounter;
                }
            }
            resultMessage += "Циклов длины " + (i+1) + ": " + cycleCounter + "<br>";
        }
        resultMessage += "</html>";
        return resultMessage;
    }



    public static boolean[][][] computeReachabilityTensor (boolean[][] adjacencyMatrix){
        int matrixSize = adjacencyMatrix.length;
        boolean[][][] reachabilityTensor = new boolean[matrixSize][][];
        for(int i =0; i < matrixSize; i++){
            //todo consider about optimization (multipleMatrix instead of powerBooleanMatrix)
            boolean[][] resultMatrix = CommonMatrixUtils.powerBoolMatrix(adjacencyMatrix, i+1);
            reachabilityTensor[i] = resultMatrix;
        }
        return reachabilityTensor;
    }

    public static String reachabilityTensorToString (boolean[][][] reachabilityTensor){
        String resultMessage = "<html>";
        int tensorsize = reachabilityTensor.length;
        for(int i = 0; i < tensorsize; i++){
            resultMessage += CommonMatrixUtils.matrixToString(CommonMatrixUtils.convertToRealMatrix(reachabilityTensor[i])) + "<br><br>";
        }
        resultMessage += "</html>";
        return resultMessage;
    }
}
