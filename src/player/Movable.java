package player;
import property.Property;

public interface Movable extends Identifiable {
    //void move(int diceRoll);
    //maybe have
    //
    Property move(int diceRoll);
    //
    //to return the tile/property that was landed on
}
