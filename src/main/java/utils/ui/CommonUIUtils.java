package utils.ui;

import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import ui.AppInitialize;

import javax.swing.*;
import java.awt.*;

public class CommonUIUtils {

    public static void visualizeGraph(Graph graph, AppInitialize app){
        if(graph != null){
            Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
            viewer.enableAutoLayout();
            ViewPanel viewPanel = viewer.addDefaultView(false);

            BorderLayout layout = (BorderLayout)app.getMainPanel().getLayout();
            Component c = layout.getLayoutComponent(BorderLayout.CENTER);
            if(c != null){
                app.getMainPanel().remove(c);
            }
            app.addPanel(viewPanel, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(app.getMainFrame());
        } else {
            System.out.println("GRAPH IS NULL");
        }
    }
}
