package buttons;

import transactions.ExpenditureTransaction;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JailButtons extends Button {

    public List<Component> showButtons(Player player)
    {
        PLAYER = player;
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makePay());

        return buttonList;
    }

    public JButton makePay()
    {
        JButton pay = new JButton("Pay to get out");

        pay.addActionListener(new ActionListener() {
            boolean payed = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!payed){
                    new ExpenditureTransaction(PLAYER, 50);
                    beenPayed();
                }
                else{
                    System.out.println("already payed" + PLAYER.balance());
                }
            }
            void beenPayed(){
                payed = true;
            }
        });

        return pay;
    }
}
