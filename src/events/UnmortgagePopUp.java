package events;

import player.Player;
import property.*;
import transactions.UnmortgageTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class UnmortgagePopUp {
    private static Player PLAYER;
    public UnmortgagePopUp(Player p){
        PLAYER = p;
    }

    public void print() {
        ArrayList<Tile> properties = PLAYER.getMortProperties();

        JFrame frame = new JFrame("Mortgaged Properties");
        frame.setUndecorated(true);
        int x = Math.max(350, PLAYER.getMortProperties().size() * 30);
        frame.setBounds(100,50,250, x);

        ImageIcon icon = new ImageIcon("Resources/Images/BankWithdrawal.png");
        JLabel label = new JLabel();
        label.setIcon(icon);

        BoxLayout b = new BoxLayout(label, BoxLayout.Y_AXIS);
        label.setLayout(b);
        label.add(Box.createRigidArea(new Dimension(15, 110)));

        Iterator<Tile> I = properties.listIterator();
        while(I.hasNext()){
            Tile t = I.next();
            JButton j = new JButton(t.getIdentifier());
            label.setComponentZOrder(j, 0);
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("before: " + PLAYER.balance());
                    new UnmortgageTransaction(PLAYER, (Property)t);
                    System.out.println("after: " + PLAYER.balance());
                    j.removeActionListener(this);
                }
            } );
            j.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.add(j);
        }

        JButton finish = new JButton("finish");
        finish.setSize(100, 50);
        finish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        } );

        JPanel p = new JPanel();
        p.add(label);

        frame.add(p);
        frame.add(finish, BorderLayout.AFTER_LAST_LINE);
        frame.validate();
        frame.setVisible(true);

    }

}
