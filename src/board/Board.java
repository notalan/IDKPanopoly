package board;
import property.Property;

import javax.swing.*;
import java.awt.*;


public class Board extends JFrame {
    public Board(){
        JFrame panopoly = new JFrame("Panoopoly");
        panopoly.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panopoly.setUndecorated(true);
        panopoly.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel(new GridLayout());
//        panel.setPreferredSize(new Dimension(1280,720)); // can resize it if needed
    }

}
