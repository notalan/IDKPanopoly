import board.Board;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args){
        Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.
        panopoly.setVisible(true);
        JPanel panel = new JPanel(new GridLayout());
        panel.setPreferredSize(new Dimension(1280,720));

        JLabel test = new JLabel("Example of adding a label in");
        test.setHorizontalAlignment(JLabel.CENTER);
        test.setVerticalAlignment(JLabel.CENTER);
        panel.add(test);
        panopoly.add(panel);
        panopoly.pack();

    }
}
