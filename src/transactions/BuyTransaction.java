package transactions;
import player.Player;
import property.*;
public class BuyTransaction{
    public BuyTransaction(Player player, Property prop){
        player.pay(prop.getPrice());
        prop.buyTile(player);


/*
    section made for updating whole board when a transaction takes place but unnecessary, keeping just in case
 */
//        for(Tile tile: tileList){
//            if(prop.equals(tile)){
//                Property p = (Property)tile;
//                p.buyTile(player);
//                break;
//            }
//        }
//        for(Player p: playerList){
//            p.updateBoard(tileList);
//        }
    }
}
