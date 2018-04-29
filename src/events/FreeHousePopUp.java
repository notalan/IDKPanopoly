package events;

import cardDeck.FreeHouseCard;
import player.Player;
import property.ImproveProperty;
import property.Tile;
import transactions.BuildHouseTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FreeHousePopUp extends JFrame {
    public FreeHousePopUp(Player p){
        setUndecorated(true);
        ArrayList<Tile> monopProps = new ArrayList<>();

        for(Tile t : p.getOwnedProperties()){
            t = (ImproveProperty)t;
            if(((ImproveProperty) t).monopolyCheck() && ((ImproveProperty) t).getConstructable()){
                monopProps.add(t);
            }
        }


        int x = Math.max(350, p.CARDS.size() * 30);
        setBounds(150,150,250, x);

        ImageIcon icon = new ImageIcon("Resources/Images/BankWithdrawal.png");
        JLabel label = new JLabel();
        label.setIcon(icon);

        BoxLayout b = new BoxLayout(label, BoxLayout.Y_AXIS);
        label.setLayout(b);
        label.add(Box.createRigidArea(new Dimension(15, 110)));

        if (monopProps.size() > 0) {
            for (Tile t : monopProps) {
                JButton j = new JButton(t.getIdentifier());
                label.setComponentZOrder(j, 0);
                j.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new BuildHouseTransaction(p, (ImproveProperty)t);
                        dispose();
                    }
                });
                j.setAlignmentX(Component.CENTER_ALIGNMENT);
                label.add(j);
            }
        }
        else{
            JButton exit = new JButton("No Buildable Houses");
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p.CARDS.add(new FreeHouseCard(p)); //if it doesn't work doesn't use up the card
                    dispose();
                }
            });
            label.add(exit);
        }
        add(label);
        setVisible(true);
    }
}