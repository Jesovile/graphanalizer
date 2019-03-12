package ui;

import jdk.nashorn.internal.objects.annotations.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DefaultLeftPanelImpl {

    private JPanel leftPanel;
    private DefaultInfoPanel infoPanel;
    private ActionListener listener;

    public DefaultLeftPanelImpl(int width, int height, ActionListener listener, DefaultInfoPanel infoPanel){
        this.infoPanel = infoPanel;
        this.listener = listener;
        this.leftPanel = initLeftPanel(width, height);

    }

    protected JPanel initLeftPanel(int width, int height){
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(width, height));
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.black));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.white);

        //TODO refactor it later
        JButton fileButton = new JButton("Загрузить из файла");
        fileButton.addActionListener(this.listener);
        leftPanel.add(fileButton, BorderLayout.NORTH);

        //todo refactor
        leftPanel.add(this.infoPanel.getPanel(), BorderLayout.CENTER);

        return leftPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public DefaultInfoPanel getInfoPanel(){
        return this.infoPanel;
    }
}
