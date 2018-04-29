package cardDeck;

import events.FreeHousePopUp;
import player.Player;

import javax.swing.*;

public class FreeHouseCard implements PlayableCard{
    private Player Player;
    public FreeHouseCard(Player p){
        Player = p;
    }
    @Override
    public String getName() {
        return "Free House Card";
    }

    @Override
    public String getEffect() {
        return "Free house on any monopolised tile";
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("Resources/Images/HouseCardImage.png");
    }

    @Override
    public int getWorth() {
        return 400;
    }

    @Override
    public void use(){
        new FreeHousePopUp(Player);
        //each actionListener will .dispose the window after calling line below
    }
}
