package buttons;

import dice.Dice;
import events.CardListPopUp;
import events.MortgagePopUp;
import events.UnmortgagePopUp;
import player.Player;
import property.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class Buttons {

    Player PLAYER;
    Tile TILE;

    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];
    public List<Component> showButtons(Player player)
    {
        PLAYER = player;
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        if(player.getOwnedProperties().size() > 0)
            buttonList.add(makeMortgage());
        if(player.getMortProperties().size() > 0)
            buttonList.add(makeUnMortgage());
        return buttonList;
    }

    public JButton makeRoll()
    {
        JButton roll = new JButton("Roll");

        roll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dice dice = new Dice();
                int rolled_result = dice.rollDice(2, 6);
                System.out.println(PLAYER.name());
                PLAYER.move(rolled_result);
                System.out.println("Rolled: " + rolled_result + " " + PLAYER.Location().getIdentifier());
            }

        } );
        return roll;
    }

    public JButton makeMortgage() {
        JButton mortgage = new JButton("Mortgage");

        mortgage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                new MortgageTransaction(PLAYER, (ImproveProperty) TILE);
                new MortgagePopUp(PLAYER).print();
            }
        });
        return mortgage;
    }

    public JButton makeUnMortgage() {
        JButton unmortgage = new JButton("UnMortgage");

        unmortgage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new UnmortgagePopUp(PLAYER).print();
            }
        });
        return unmortgage;
    }

    public JButton makeCardHand() {
        JButton cardHand = new JButton("Cards");

        cardHand.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new CardListPopUp(PLAYER);
            }
        });
        return cardHand;
    }
}
