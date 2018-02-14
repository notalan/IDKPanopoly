package player;

public interface Movable extends Identifiable {
    void move(int diceRoll);
    //maybe have
    //
    //      Property move(diceRoll);
    //
    //to return the tile/property that was landed on
}
