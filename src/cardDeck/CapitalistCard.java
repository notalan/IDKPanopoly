package cardDeck;

import player.Player;

public class CapitalistCard implements PlayableCard {
    private Player[] P_LIST;
    public CapitalistCard(Player[] list){
        P_LIST = list;
    }
    @Override
    public String getName() {
        return "Capitalist Card";
    }

    @Override
    public String getEffect() {
        return "Winners keepers - losers weepers!";
    }

    @Override
    public void use() {
        int total = 0;
        for(Player p : P_LIST){
            total += p.balance();
        }
        int average = total / P_LIST.length;
        for(Player p : P_LIST){
            if(p.balance() > average)
                p.receiveIncome(75);
            else
                p.pay(75);
        }
    }
}
