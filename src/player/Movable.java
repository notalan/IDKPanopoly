package player;
import property.*;

public interface Movable extends Identifiable {
    //void move(int diceRoll);
    //maybe have
    //
    Tile move(int diceRoll);
    //
    //to return the tile/property that was landed on
}
