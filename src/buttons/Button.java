package buttons;

import dice.Dice;
import board.Board;
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

public class Button {

    Player PLAYER;
    Tile TILE;

    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());

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
}
