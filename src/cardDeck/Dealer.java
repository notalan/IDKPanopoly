package cardDeck;

import player.Player;
import property.ImproveProperty;
import property.Tile;

import javax.swing.*;
import java.util.Random;

/*
Deals a card from the deck
 */
public class Dealer {
    private Player[] P_LIST;
    private Player Player;
    public Dealer(Player p, Player[] list){
        P_LIST = list;
        Player = p;
    }

    public PlayableCard drawCard(){
        Random rand = new Random();
        int chooser = rand.nextInt(4);
        System.out.println(chooser);
        switch (chooser){
            case 0:
                return new FreeHouseCard(Player);
            case 1:
                return new CommunistCard(P_LIST);
            case 2:
                return new CapitalistCard(P_LIST);
            case 3:
                return new FYFCard(Player, P_LIST);
        }
        //not supposed to ever reach here bc of switch statement but if there's a bug and it returns this
        //then the least we can do is give the player a thousand bob :)
        return new PlayableCard() {
            @Override
            public String getName() {
                return "eep";
            }

            @Override
            public String getEffect() {
                return "not_supposed_to_happen.JPEG";
            }

            @Override
            public ImageIcon getIcon() {
                return new ImageIcon("Resources/Images/quitbutton.png");
            }

            @Override
            public int getWorth() {
                return 0;
            }

            @Override
            public void use() {
                Player.receiveIncome(1000);
            }
        };
    }
}
