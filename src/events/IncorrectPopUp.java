package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncorrectPopUp extends JFrame {
    public IncorrectPopUp(){
        setUndecorated(true);
        setBounds(100, 100, 300, 220);
        JPanel p = new JPanel();
        Icon I = new ImageIcon("Resources/Images/IncorrectPopUp.png");
        JLabel l = new JLabel();
        l.setIcon(I);
        p.add(l);
        JButton finished = new JButton("Sad Reacts Only Pls");
        finished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(p);
        add(finished, BorderLayout.AFTER_LAST_LINE);
        setVisible(true);

    }

}
