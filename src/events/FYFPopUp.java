package events;

import player.Player;
import transactions.ExpenditureTransaction;
import transactions.IncomeTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FYFPopUp extends JFrame{
    public FYFPopUp(final Player p, Player[] list){
        setUndecorated(true);
        int x = Math.max(350, p.getMortProperties().size() * 30);
        setBounds(100,50,250, x);

        ImageIcon icon = new ImageIcon("Audio/BankWithdrawl.png");
        JLabel label = new JLabel();
        label.setIcon(icon);

        BoxLayout b = new BoxLayout(label, BoxLayout.Y_AXIS);
        label.setLayout(b);

        for(final Player player : list){
            JButton j = new JButton(player.name());
            label.setComponentZOrder(j, 0);
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ExpenditureTransaction(player, 200);
                    new IncomeTransaction(p, 200);
                    dispose();
                }
            } );
            j.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.add(j);
        }

        add(label);
        setVisible(true);

    }
}