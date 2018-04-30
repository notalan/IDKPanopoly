package board;

import javax.swing.*;
import java.awt.*;


public class Board extends JFrame {
    public void paint(Graphics g){
        super.paint(g);
    }

    public void setBackground(Color color){
        super.setBackground(color);
        getContentPane().setBackground(color);
    }
    public Board(){
        JFrame panopoly = new JFrame("Panoopoly");
        panopoly.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panopoly.setUndecorated(true);
        panopoly.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panopoly.setBackground(Color.BLACK);
    }
}
