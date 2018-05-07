package board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerMenuButtons {
    public JButton nextButton(final JFrame playermenu, final Board panopoly)
    {
        JButton next = new JButton();
        next.setIcon(new ImageIcon("Resources/Images/next.png"));
        next.setBorder(new EmptyBorder(0,0,0,0));

        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panopoly.setVisible(true);
                playermenu.dispose();

            }

        } );
        return next;
    }
}