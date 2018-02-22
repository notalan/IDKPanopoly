package transactions;
import player.Player;
import property.*;
public class BuyTransaction{
    public BuyTransaction(Player player, Property prop){
        player.buyProperty(prop.getPrice());
        prop.buyTile(player);
    }
}
