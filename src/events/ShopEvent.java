package events;

import cardDeck.Dealer;
import cardDeck.PlayableCard;
import player.Player;
import property.Go;
import property.Tile;

import javax.swing.*;
import java.awt.*;

public class ShopEvent extends JFrame{
    public ShopEvent(Player p, Player[] l) {
        PlayableCard card1 = new Dealer(p, l).drawCard();
        PlayableCard card2 = new Dealer(p, l).drawCard();
        setUndecorated(true);
        setBounds(200, 100, 600, 450);

        JPanel label = new JPanel();
        //top
        JLabel left = new JLabel(card1.getIcon());
        left.setLayout(new BoxLayout(left, BoxLayout.X_AXIS));
        left.add(Box.createRigidArea(new Dimension(80, 10)));
        left.add(new JButton("BUY"));
        //bottom
        JLabel right = new JLabel(card2.getIcon());
        right.setLayout(new BoxLayout(right, BoxLayout.X_AXIS));
        right.add(Box.createRigidArea(new Dimension(80, 10)));
        right.add(new JButton("BUY"));

        label.add(left);
        label.add(right);

        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ShopEvent(new Player("bob", 1000, new Go("go", 0, 0), new Tile[]{}), new Player[]{});
    }
}
