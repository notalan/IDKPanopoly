package board;
import property.Property;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    public Board(){
        JFrame panopoly = new JFrame();
        panopoly.setTitle("Panopoly");
        panopoly.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout());
        panel.setPreferredSize(new Dimension(1280,720)); // can resize it if needed

        JLabel test = new JLabel("Example of adding a label in");
        test.setHorizontalAlignment(JLabel.CENTER);
        test.setVerticalAlignment(JLabel.CENTER);
        panel.add(test);
        panopoly.add(panel);
    }

}
