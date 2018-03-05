import board.Board;
import buttons.ChooseButtons;
import dice.Dice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;


public class main {
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public static void main(String[] args){
        Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.
        JPanel panel = new JPanel(new GridLayout());
        JLabel test = new JLabel(new ImageIcon("C:\\Users\\1997a\\Documents\\IDKPanopoly\\src\\dewey.jpg"));
        panel.add(test);
        JPanel buttonPanel = new JPanel();
//        buttonPanel.setPreferredSize(new Dimension(560, 100));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        ListIterator<Component> iterator = new ChooseButtons().showButtons().listIterator();
        while(iterator.hasNext())
        {
            buttonPanel.add(iterator.next());
        }
        panel.add(buttonPanel, BorderLayout.CENTER);
        panopoly.add(panel);
        panopoly.setUndecorated(true); // hides close, minimize, fullscreen

        JButton btn1 = new JButton("Full-Screen");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(panopoly);
            }
        });
        JButton btn2 = new JButton("Normal");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(null);
            }
        });
        panel.add(btn1);
        panel.add(btn2);
        panopoly.add(panel);

        panopoly.pack();
        panopoly.setVisible(true);

        Dice dice = new Dice(); //Test rolling dice
        System.out.println(dice.rollDice(2, 6));
    }
}
