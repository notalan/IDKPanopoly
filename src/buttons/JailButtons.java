package buttons;

import dice.Dice;
import events.PayedOutOfJailPopUp;
import events.RolledOutOfJailFailPopUp;
import events.RolledOutOfJailPopUp;
import transactions.ExpenditureTransaction;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JailButtons extends Buttons {

    public List<Component> showButtons(Player player)
    {
        PLAYER = player;
        ArrayList<Component> buttonList = new ArrayList<>();
        //buttonList.add(makeRoll());
        if(player.isJailed()) {
            buttonList.add(makePay());
            buttonList.add(makeRollToGetOut());
        }

        return buttonList;
    }

    public JButton makeRollToGetOut()
    {
        JButton roll = new JButton();
        roll.setIcon(new ImageIcon("Resources/Images/roll.png"));

        roll.addActionListener(new ActionListener() {
            boolean rolled = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!rolled) {
                    Dice dice = new Dice();
                    if (dice.rollDice(1, 6) == dice.rollDice(1, 6)) {
                        PLAYER.freeFromChains();
                        RolledOutOfJailPopUp R = new RolledOutOfJailPopUp();
                    }
                    else {
                        RolledOutOfJailFailPopUp F = new RolledOutOfJailFailPopUp();
                    }
                    beenRolled();
                }
                else{
                    //already Rolled popup
                    }
            }
            void beenRolled(){ rolled = true; }
        } );
        return roll;
    }
    public JButton makePay()
    {
        JButton pay = new JButton("Pay to get out");
        pay.setIcon(new ImageIcon("Resources/Images/paytogetout.png"));
        pay.addActionListener(new ActionListener() {
            boolean payed = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!payed){
                    new ExpenditureTransaction(PLAYER, 50);
                    PLAYER.freeFromChains();
                    beenPayed();
                    PayedOutOfJailPopUp P = new PayedOutOfJailPopUp();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    }catch(Exception E){
                        E.printStackTrace();
                    }
                    P.dispose();
                }
                else{

                }
            }
            void beenPayed(){
                payed = true;
            }
        });

        return pay;
    }
}
