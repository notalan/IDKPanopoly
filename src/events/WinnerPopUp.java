package events;

import board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerPopUp extends JFrame{
    public WinnerPopUp(String player, final Board panopoly) {
        setBounds(160,255,400,210);
        setUndecorated(true);
        JLabel text = new JLabel(player + " WINS!!");
        text.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(text);

        JButton finish = new JButton("EXIT");
        finish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panopoly.dispose();
            }
        } );

        add(finish, BorderLayout.AFTER_LAST_LINE);

        setAlwaysOnTop(true);
        setVisible(true);
    }
}
