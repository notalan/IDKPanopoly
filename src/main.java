import board.Board;
import buttons.ChooseButtons;

import javax.swing.*;
import java.awt.*;
import java.util.ListIterator;

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

        JPanel buttonPanel =  new JPanel();
        buttonPanel.setPreferredSize(new Dimension(560, 100));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        ListIterator<Component> iterator = new ChooseButtons().showButtons().listIterator();
        while(iterator.hasNext())
        {
            buttonPanel.add(iterator.next());
        }
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panopoly.add(panel);
        panopoly.pack();

    }
}
