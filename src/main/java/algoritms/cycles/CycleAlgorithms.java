package algoritms.cycles;

import java.util.ArrayList;

public class CycleAlgorithms {

    /*FIELDS*/
    private boolean[][][] reachabilityTensor;
    private boolean[][] adjacencyMatrix;
    private int tensorSize;

    public CycleAlgorithms(boolean[][][] reachabilityTensor){
        this.reachabilityTensor = reachabilityTensor;
        this.adjacencyMatrix = reachabilityTensor[0];
        this.tensorSize = reachabilityTensor.length;
    }

    /*METHODS*/
    public String cycleAnalize(){

        int lastMatrixIndex = tensorSize-1;
        boolean[][] lastMatrix = reachabilityTensor[lastMatrixIndex];

        //todo refactor
        String resultMessage = "<html>";

        //last matrix iteration
        for (int i = 0; i < tensorSize; i++) {
//        for (int i = 4; i < 5; i++) {
            if (lastMatrix[i][i]) {
                int[][] route = new int[this.tensorSize][2];
                for(int t=0; t<route.length; t++){
                    route[t][0]=-1;
                    route[t][1]=-1;
                }
                //run algorithm
                //init step variables
                int stepCount = 1;
                int rowIndex = i;
                int colIndex = i;
                //recursive loop
                while (this.tensorSize - stepCount != -1) {
                    this.cycleAnalizeStep(rowIndex, colIndex, route, stepCount);
                    //rowIndex = route[stepCount-1][1];
                    colIndex = route[stepCount-1][0];
                    stepCount++;
                }
                resultMessage += this.routeToString(route, i);
            }
        }
        return resultMessage + "</html>";
    }

    private void cycleAnalizeStep (int rowIndex, int colIndex, int[][] route, int stepCounter){
        if (stepCounter == this.tensorSize) {
            route[stepCounter - 1][0] = rowIndex;
            route[stepCounter - 1][1] = colIndex;
        } else {
            for (int i = 0; i < this.tensorSize; i++) {
                if (this.adjacencyMatrix[i][colIndex] && this.reachabilityTensor[this.tensorSize - 1 - stepCounter][rowIndex][i]) {
                    route[stepCounter-1][0] = i;
                    route[stepCounter-1][1] = colIndex;
                    break;
                }
            }
        }
    }

    //todo move it to ui utils
    public String routeToString(int[][] route, int lastMatrixElementIndex){
        String resultMessage = "";
        resultMessage += "Цикл элемента " + lastMatrixElementIndex + ":<br>";
        resultMessage += route[route.length-1][0] + "->" + route[route.length-1][1];
        for(int i=route.length-2; i>=0; i=i-1){
            resultMessage += "->" + route[i][1];
        }
        resultMessage += "<br>";
        return resultMessage;
    }
}
