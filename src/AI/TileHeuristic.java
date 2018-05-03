package AI;
/*
Class maps a given tile to an integer value, the higher the value the better the tile
 */
import property.Tile;

class TileHeuristic {
    Tile T;
    int Heuristic;
    TileHeuristic(Tile t){
        T = t;
    }

    void setHeuristic() {
        //chance of landing on it + owned other props of same colour + price compared to balance?
        // * other player owns same colour (0 or 1)
        Heuristic = 1;
    }
}
