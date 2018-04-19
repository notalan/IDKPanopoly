package buttons;

import chestChanceCards.Chooser;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommunityChestButtons extends Buttons{
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
                    Random rand = new Random();
                    int choice = rand.nextInt(100) + 1;
                    new Chooser(choice, PLAYER).callCard();
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
