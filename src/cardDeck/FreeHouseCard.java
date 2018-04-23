package cardDeck;

import player.Player;

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
        return "Gives a free house on any of your monopolised tiles";
    }

    @Override
    public void use(){
        //new FreeHousePopUp(Player, LOCATION);
        //each actionListener will .dispose the window after calling line below
//        new BuildHouseTransaction(Player, LOCATION);
    }
}
