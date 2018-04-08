package events;
import player.Player;
import property.StationTile;
import property.Tile;
import transactions.ExpenditureTransaction;

public class ChooseEvent {
    public ChooseEvent(Player p, Tile t){
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
        /*
        else if(t instanceof ShopTile){

        }
        else if(t instanceof MinigameTile){

        }
         */

    }

}
