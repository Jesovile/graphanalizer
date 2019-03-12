package ui;

import javax.swing.*;
import java.awt.*;

public class AppInitialize {

    //main JFrame of application
    private JFrame mainFrame;

    //Main constructor
    public AppInitialize(){
        this.mainFrame = this.createMainFrame();
    }


    //inner method for creating main JFrame of application
    protected JFrame createMainFrame(){
        JFrame mainframe = new JFrame("Main");
        mainframe.setMinimumSize(new Dimension(1000, 800));
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setLayout(new BorderLayout());



        return mainframe;
    }

    public void startApp(){
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }

    public void addPanel(JPanel panel, String position){
        this.mainFrame.getContentPane().add(panel, position);
    }

    public Container getMainPanel(){
        return this.mainFrame.getContentPane();
    }

    public JFrame getMainFrame(){
        return this.mainFrame;
    }
}
