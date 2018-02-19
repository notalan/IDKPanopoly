package buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {
    public JButton makeRoll()
    {
        JButton roll = new JButton("Roll");

        roll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Rolled");

            }

        } );

        return roll;
    }
}
