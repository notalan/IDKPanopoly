package transactions;

import player.Player;
import property.ImproveProperty;


public class TradeTransaction {
    public TradeTransaction(Player player1, Player player2,  ImproveProperty prop){
        player1.removeProperty(prop);
        player2.addProperty(prop);
        prop.buyTile(player2);
    }

    public TradeTransaction(Player player1, Player player2 /*, Card card*/){
    }
}
