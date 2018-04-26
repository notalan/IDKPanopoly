package cardDeck;

import events.FYFPopUp;
import player.Player;

import javax.swing.*;

public class FYFCard implements PlayableCard{
    private Player PLAYER;
    private Player[] PLAYER_LIST;
    public FYFCard(Player p, Player[] l){
        PLAYER = p;
        PLAYER_LIST = l;
    }


    @Override
    public String getName() {
        return "F*!@ Your Friends";
    }

    @Override
    public String getEffect() {
        return "!Target Acquired!";
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("Resources/Images/FYFCardImage.png");
    }
    @Override
    public void use() {
        new FYFPopUp(PLAYER, PLAYER_LIST);
    }
}
