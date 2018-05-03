package events;
import AirHockey.src.AirHockey;
import player.Player;
import property.MiniGame;
import property.Shop;
import property.StationTile;
import property.Tile;
import transactions.ExpenditureTransaction;

public class ChooseEvent {
    public ChooseEvent(Player p, Tile t, Player[] listOfPlayers){
        if(t instanceof StationTile){
            Object[] move = ((StationTile) t).getDestination();
            new TrainPopUp(t.getIdentifier(), (String)move[1]);
            if(move[0].equals(10)){
                p.moveToJail();
            }
            else{
                while(p.currentPlace != (int)move[0]){
                    p.move(1);
                }
                //if(!p.own(leapCarp))
                new ExpenditureTransaction(p, 2.85);
            }

        }

        else if(t instanceof Shop){
            new ShopEvent(p,listOfPlayers);
        }
        else if(t instanceof MiniGame){
            new AirHockey();
        }


    }

}
