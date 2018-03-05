import board.Board;
import buttons.ChooseButtons;
import dice.Dice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ListIterator;

public class main {
    public static void main(String[] args){
        Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.

        JPanel panel = new JPanel(new GridLayout());
        ImageIcon img = new ImageIcon("C:\\Users\\1997a\\Documents\\IDKPanopoly\\src\\dewey.jpg");
        JLabel test = new JLabel(img);
        panel.add(test);
        JPanel buttonPanel =  new JPanel();
        buttonPanel.setPreferredSize(new Dimension(560, 100));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        ListIterator<Component> iterator = new ChooseButtons().showButtons().listIterator();
        while(iterator.hasNext())
        {
            buttonPanel.add(iterator.next());
        }
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(1280,720));
        panopoly.add(panel);
        panopoly.pack();
        panopoly.setVisible(true);

        Dice dice = new Dice(); //Test rolling dice
        System.out.println(dice.rollDice(2, 6));
    }
}
