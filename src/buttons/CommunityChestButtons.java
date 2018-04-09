package buttons;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CommunityChestButtons extends Button{
    public List<Component> showButtons(Player currentPlayer)
    {
        PLAYER = currentPlayer;
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeDrawCommunityChestCard());

        return buttonList;
    }

    public JButton makeDrawCommunityChestCard()
    {
        JButton drawCard = new JButton("Draw Card");

        drawCard.addActionListener(new ActionListener() {
            boolean drawn = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!drawn){
                    //draw a card
                    beenPayed();
                }
                else{
                    System.out.println("already drawn");
                }
            }
            void beenPayed(){
                drawn = true;
            }
        } );

        return drawCard;
    }
}
