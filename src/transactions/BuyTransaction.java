package transactions;
import player.Player;
import property.*;
public class BuyTransaction{
    public BuyTransaction(Player player, ImproveProperty prop){
        player.pay(prop.getPrice());
        player.addProperty(prop);
        prop.buyTile(player);

        String colour = prop.colourOfTiles; // Colour check
        int count = 0;
        for (int i = 0; i < player.getOwnedProperties().size(); i++)
        {
            String temp = ((ImproveProperty)player.getOwnedProperties().get(i)).colourOfTiles;
            if(colour.equals (temp))
            {
              count++;
            }
        }

        if (colour.equals("Brown") || colour.equals("DBlue"))
        {
            if(count == 2)
            {
                for (int i = 0; i < player.getOwnedProperties().size(); i++)
                {
                    String temp = ((ImproveProperty)player.getOwnedProperties().get(i)).colourOfTiles;
                    if(colour.equals (temp))
                    {
                        ((ImproveProperty)player.getOwnedProperties().get(i)).monopolySet();
                    }
                }
            }
        }
        else{
            if(count == 3)
            {
                for (int i = 0; i < player.getOwnedProperties().size(); i++)
                {
                    String temp = ((ImproveProperty)player.getOwnedProperties().get(i)).colourOfTiles;
                    if(colour.equals (temp))
                    {
                        ((ImproveProperty)player.getOwnedProperties().get(i)).monopolySet();
                    }
                }
            }

        }

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

    public BuyTransaction(Player player, ImproveProperty prop, double price) {
        player.pay(price);
        player.addProperty(prop);
        prop.buyTile(player);

        String colour = prop.colourOfTiles; // Colour check
        int count = 0;
        for (int i = 0; i < player.getOwnedProperties().size(); i++) {
            String temp = ((ImproveProperty) player.getOwnedProperties().get(i)).colourOfTiles;
            if (colour.equals(temp)) {
                count++;
            }
        }

        if (colour.equals("Brown") || colour.equals("DBlue")) {
            if (count == 2) {
                for (int i = 0; i < player.getOwnedProperties().size(); i++) {
                    String temp = ((ImproveProperty) player.getOwnedProperties().get(i)).colourOfTiles;
                    if (colour.equals(temp)) {
                        ((ImproveProperty) player.getOwnedProperties().get(i)).monopolySet();
                    }
                }
            }
        } else {
            if (count == 3) {
                for (int i = 0; i < player.getOwnedProperties().size(); i++) {
                    String temp = ((ImproveProperty) player.getOwnedProperties().get(i)).colourOfTiles;
                    if (colour.equals(temp)) {
                        ((ImproveProperty) player.getOwnedProperties().get(i)).monopolySet();
                    }
                }
            }

        }
    }
}
