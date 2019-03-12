import ui.AppInitialize;
import ui.DefaultInfoPanel;
import ui.DefaultLeftPanelImpl;
import ui.FileChooseHandler;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");


        //GUI init
        AppInitialize app = new AppInitialize();


        DefaultInfoPanel infoPanel = new DefaultInfoPanel(300, app.getMainPanel().getHeight() / 2);
        FileChooseHandler listener = new FileChooseHandler(app, infoPanel);

        DefaultLeftPanelImpl leftPanel = new DefaultLeftPanelImpl(300, app.getMainPanel().getHeight(), listener, infoPanel);

        app.addPanel(leftPanel.getLeftPanel(), BorderLayout.WEST);
        app.startApp();
    }
}
