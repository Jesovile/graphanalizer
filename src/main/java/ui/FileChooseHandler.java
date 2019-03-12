package ui;

import algoritms.CommonAlgorithms;
import algoritms.cycles.CycleAlgorithms;
import generator.DefaultGraphFactoryImpl;
import io.matrix.FileMatrixReader;
import io.matrix.TextFileMatrixReader;
import org.graphstream.graph.Graph;
import generator.GraphFactory;
import utils.matrix.CommonMatrixUtils;
import utils.ui.CommonUIUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class FileChooseHandler implements ActionListener {

    /*FIELDS*/
    //TODO refactor with DI
    private AppInitialize app;
    private DefaultInfoPanel infoPanel;
    private GraphFactory graphFactory;
    private FileMatrixReader matrixReader;

    public FileChooseHandler(AppInitialize app, DefaultInfoPanel infoPanel) {
        this.app = app;
        this.infoPanel = infoPanel;
        this.graphFactory = new DefaultGraphFactoryImpl();
        this.matrixReader = new TextFileMatrixReader();
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();

            //read adjacency matrix from chosen file
            ArrayList<ArrayList<Integer>> matrix = this.matrixReader.readMatrixFromFile(file);

            //matrix multiple and output
            boolean[][] matrix1 = CommonMatrixUtils.convertToBooleanMatrix(matrix);

            //cycle counter output
            //this.infoPanel.setInfo(CommonAlgorithms.cycleAnalize(CommonAlgorithms.computeReachabilityTensor(matrix1)));

            //cycle route output
            this.infoPanel.setInfo(new CycleAlgorithms(CommonAlgorithms.computeReachabilityTensor(matrix1)).cycleAnalize());

            //reachabilityTensor output
            //this.infoPanel.setInfo(CommonAlgorithms.reachabilityTensorToString(CommonAlgorithms.computeReachabilityTensor(matrix1)));

            //create and draw graph
            Graph graph = this.graphFactory.createGraphFromMatrix(matrix);
            CommonUIUtils.visualizeGraph(graph, this.app);
        }
    }
}