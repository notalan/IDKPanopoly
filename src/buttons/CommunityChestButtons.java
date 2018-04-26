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
    private Player[] P_LIST;
    public List<Component> showButtons(Player currentPlayer, Player[] list)
    {
        PLAYER = currentPlayer;
        P_LIST = list;
        ArrayList<Component> buttonList = new ArrayList<>();
        //buttonList.add(makeRoll());
        buttonList.add(makeDrawCommunityChestCard());
        if(currentPlayer.getOwnedProperties().size() > 0)
            buttonList.add(makeMortgage());
        if(currentPlayer.getMortProperties().size() > 0)
            buttonList.add(makeUnMortgage());
        if(currentPlayer.CARDS.size() > 0)
            buttonList.add(makeCardHand());
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
                    new Chooser(choice, PLAYER, P_LIST).callCard();
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
