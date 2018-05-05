package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RolledOutOfJailFailPopUp extends JFrame {
    public RolledOutOfJailFailPopUp() {
        setBounds(200,300,400,210);
        setUndecorated(true);
        JLabel text = new JLabel("FAILED ROLL (rolled non equal dice)");
        add(text);

        JButton finish = new JButton("EXIT");
        finish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        } );

        add(finish, BorderLayout.AFTER_LAST_LINE);

        setAlwaysOnTop(true);
        setVisible(true);
    }
}
