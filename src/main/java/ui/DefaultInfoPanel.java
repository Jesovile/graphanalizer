package ui;

import javax.swing.*;
import java.awt.*;

public class DefaultInfoPanel {

    private JPanel panel;

    public DefaultInfoPanel(int width, int height){
        this.panel = initPanel(width, height);
    }

    private JPanel initPanel(int width, int height){
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(width, height));
        panel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black));
        panel.setBackground(Color.lightGray);

        JLabel label = new JLabel();
        label.setFont(new Font("Verdana", Font.PLAIN, 16));
        panel.add(label);

        return panel;
    }

    public void setInfo(String info){
        JLabel label = (JLabel) this.panel.getComponent(0);
        label.setText(info);
        SwingUtilities.updateComponentTreeUI(panel);
    }

    public void addInfo(String info){
        JLabel label = (JLabel) this.panel.getComponent(0);
        String oldInfo = label.getText() + "<br>";
        label.setText(oldInfo + info);
        SwingUtilities.updateComponentTreeUI(panel);
    }

    //for view with scrolling
    public JScrollPane getPanel(){
        return new JScrollPane(this.panel);
    }
}
