package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CorrectPopUp extends JFrame {
    public CorrectPopUp(){
        setUndecorated(true);
        setBounds(100, 100, 300, 220);
        JPanel p = new JPanel();
        Icon I = new ImageIcon("Resources/Images/CorrectImage.png");
        JLabel l = new JLabel();
        l.setIcon(I);
        p.add(l);
        JButton finished = new JButton("click to collect!");
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
