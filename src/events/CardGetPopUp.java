package events;

import cardDeck.LeapCard;
import cardDeck.PlayableCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardGetPopUp extends JFrame{
    public CardGetPopUp(PlayableCard C){
        setUndecorated(true);
        setBounds(50, 150, 350, 400);
        setAlwaysOnTop(true);

        JPanel label = new JPanel();

        JLabel left = new JLabel(C.getIcon());
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.add(Box.createRigidArea(new Dimension(80, C.getIcon().getIconHeight() - 100)));
        JTextField nameField1 = new JTextField(C.getName());
        nameField1.setHorizontalAlignment(0);
        nameField1.setEditable(false);
        left.add(nameField1);
        JTextField f1 = new JTextField(C.getEffect());
        f1.setHorizontalAlignment(0);
        f1.setEditable(false);
        left.add(f1);

        label.add(left);

        add(label);

        JButton finish = new JButton("EXIT");
        finish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        } );

        add(finish, BorderLayout.AFTER_LAST_LINE);

        setVisible(true);

    }

}
