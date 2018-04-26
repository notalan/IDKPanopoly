package cardDeck;

import player.Player;

import javax.swing.*;

/*
Card sets all player balances to be the average of all players
 */
public class CommunistCard implements PlayableCard{
    private Player[] P_LIST;

    public CommunistCard(Player[] list){
        P_LIST = list;
    }

    @Override
    public String getName() {
        return "Communist Card";
    }

    @Override
    public String getEffect() {
        return "!!Everybody Equal!!";
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("Resources/Images/CommCardImage.png");
    }

    @Override
    public void use() {
        int total = 0;
        for(Player p : P_LIST){
            total += p.balance();
        }
        int average = total / P_LIST.length;
        for(Player p : P_LIST){
            p.pay(p.balance());
            p.receiveIncome(average);
        }
    }
}
