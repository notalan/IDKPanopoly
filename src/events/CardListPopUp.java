package events;

import cardDeck.PlayableCard;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardListPopUp extends JFrame{
    public CardListPopUp(Player p){
        setUndecorated(true);
        int x = Math.max(350, p.CARDS.size() * 30);
        setBounds(150,150,250, x);

        ImageIcon icon = new ImageIcon("Resources/Images/BankWithdrawal.png");
        JLabel label = new JLabel();
        label.setIcon(icon);

        BoxLayout b = new BoxLayout(label, BoxLayout.Y_AXIS);
        label.setLayout(b);
        label.add(Box.createRigidArea(new Dimension(15, 110)));
        if (p.CARDS.size() > 0) {
            for (PlayableCard card : p.CARDS) {
                JButton j = new JButton(card.getName());
                label.setComponentZOrder(j, 0);
                j.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        card.use();
                        p.CARDS.remove(card);
                        dispose();
                    }
                });
                j.setAlignmentX(Component.CENTER_ALIGNMENT);
                label.add(j);
            }
        }
        else{
            JButton exit = new JButton("EXIT");
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            label.add(exit);
        }
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
