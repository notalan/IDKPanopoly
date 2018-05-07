package events;

import cardDeck.Dealer;
import cardDeck.PlayableCard;
import player.Player;
import property.Go;
import property.Tile;
import transactions.ExpenditureTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ShopEvent extends JFrame{
    private PlayableCard card1;
    private PlayableCard card2;
    private double amount1;
    private double amount2;
    public ShopEvent(final Player p, Player[] l) {
        card1 = new Dealer(p, l).drawCard();
        card2 = new Dealer(p, l).drawCard();
        setUndecorated(true);
        setBounds(50, 150, 720, 450);
        setAlwaysOnTop(true);

        Random rand = new Random();

        JPanel label = new JPanel();
        label.setBackground(Color.black);

        //top
        final int offset1 = rand.nextInt(100) - 50;
        amount1 = card1.getWorth() + offset1;
        JLabel left = new JLabel(card1.getIcon());
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        final JButton buy1 = new JButton("BUY - " + amount1 + "sd");
        buy1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(p.balance());
                new ExpenditureTransaction(p, card1.getWorth() + offset1);
                buy1.removeActionListener(this);
                p.CARDS.add(card1);
                System.out.println(p.balance());
                System.out.println(p.CARDS);
            }
        });
        left.add(buy1);
        left.add(Box.createRigidArea(new Dimension(80, card1.getIcon().getIconHeight() - 100)));
        JTextField nameField1 = new JTextField(card1.getName());
        nameField1.setHorizontalAlignment(0);
        nameField1.setEditable(false);
        left.add(nameField1);
        JTextField f1 = new JTextField(card1.getEffect());
        f1.setHorizontalAlignment(0);
        f1.setEditable(false);
        left.add(f1);


        //bottom
        final int offset2 = rand.nextInt(100) - 50;
        amount2 = card2.getWorth() + offset2;
        JLabel right = new JLabel(card2.getIcon());
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        final JButton buy2 = new JButton("BUY - " + amount2 + "sd");
        buy2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(p.balance());
                new ExpenditureTransaction(p, card2.getWorth() + offset2);
                buy2.removeActionListener(this);
                p.CARDS.add(card2);
                System.out.println(p.balance());
                System.out.println(p.CARDS);
            }
        });
        right.add(buy2);
        right.add(Box.createRigidArea(new Dimension(80, card2.getIcon().getIconHeight() - 100)));
        JTextField nameField2 = new JTextField(card2.getName());
        nameField2.setHorizontalAlignment(0);
        nameField2.setEditable(false);
        right.add(nameField2);
        JTextField f2 = new JTextField(card2.getEffect());
        f2.setHorizontalAlignment(0);
        f2.setEditable(false);
        right.add(f2);

        label.add(left);
        label.add(right);

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

    /*
    added for AI purposes, not great software engineering but sure look there's 4 days left
     */
    public JFrame getFrame(){
        return this;
    }

    public PlayableCard[] getCards(){
        return new PlayableCard[] {card1, card2};
    }

    public double[] getValues(){
        return new double[] {amount1, amount2};
    }

    public static void main(String[] args) {
        new ShopEvent(new Player("bob", 1000, new Go("go", 0, 0), new Tile[]{}), new Player[]{});
    }
}
