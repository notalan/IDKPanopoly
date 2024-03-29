package AI;
/*
Class maps a given tile to an integer value, the higher the value the better the tile
 */
import player.Player;
import property.ImproveProperty;
import property.Tile;

class TileHeuristic {
    ImproveProperty T;
    int Heuristic;
    TileHeuristic(Tile t){
        T = (ImproveProperty)t;
    }

    void setHeuristic(Player p) {
        int ownedByOther = 1;
        if(T.hasOwner() && !(T.owner().equals(p)))
            ownedByOther = 0;

        int partialMonopoly = 0;
        for(Tile I : p.getOwnedProperties()){
            if(((ImproveProperty)I).colourOfTiles.equals(T.colourOfTiles)){
                partialMonopoly += 100;
            }
        }

        Heuristic = (T.getPrice() + partialMonopoly) * ownedByOther;
    }
}
