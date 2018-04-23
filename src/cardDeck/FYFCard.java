package cardDeck;

import player.Player;

public class FYFCard implements PlayableCard{
    private Player PLAYER;
    public FYFCard(Player p){
        PLAYER = p;
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
    public void use() {
        //new FYFPopUp - takes in P_LIST and player, select your chosen friends
    }
}
