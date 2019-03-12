package generator;

import org.graphstream.graph.Graph;

import java.util.ArrayList;

public interface GraphFactory {
    Graph createGraphFromMatrix(ArrayList<ArrayList<Integer>> matrix);
}
