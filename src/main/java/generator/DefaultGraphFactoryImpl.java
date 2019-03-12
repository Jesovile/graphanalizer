package generator;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.ArrayList;

public class DefaultGraphFactoryImpl implements GraphFactory {

    public Graph createGraphFromMatrix(ArrayList<ArrayList<Integer>> matrix) {
        Graph graph = new SingleGraph("Tutorial 1", false, true);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                //init nodes
                if (graph.getNode(String.valueOf(j)) == null) {
                    graph.addNode(String.valueOf(j));
                }
                //init edges
                if (matrix.get(i).get(j) == 1) {
                    graph.addEdge(String.valueOf(i) + String.valueOf(j), String.valueOf(i), String.valueOf(j), true);
                }
            }
        }

        for (Node node : graph) {
            node.addAttribute("ui.label", "Node " + (Integer.valueOf(node.getId())));
        }

        return graph;
    }
}
