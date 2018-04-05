package buttons;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GoToJailButtons extends Button{
    public List<Component> showButtons(Player p)
    {
        PLAYER = p;
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeGoToJail());
        return buttonList;
    }

    public JButton makeGoToJail()
    {
        JButton goToJail = new JButton("Go to Jail");

        goToJail.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sad times criminal brother");
                PLAYER.moveToJail();
            }

        } );
        return goToJail;
    }
}
