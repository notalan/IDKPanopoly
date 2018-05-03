package buttons;

import player.Player;
import property.FreeParking;
import transactions.IncomeTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FreeParkingButtons extends Buttons{
    FreeParking F;
    public List<Component> showButtons(Player p, FreeParking f)
    {
        F = f;
        PLAYER = p;
        ArrayList<Component> buttonList = new ArrayList<>();
        //buttonList.add(makeRoll());
        buttonList.add(makeCollectMoney());
        return buttonList;
    }

    public JButton makeCollectMoney()
    {
        JButton collectMoney = new JButton();
        collectMoney.setIcon(new ImageIcon("collectmoney.png"));
        collectMoney.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new IncomeTransaction(PLAYER, F.freeParkingPool);
                F.freeParkingPool = 0.0;
            }

        } );
        return collectMoney;
    }
}
