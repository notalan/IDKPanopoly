package player;
import property.*;

public class Player implements Locatable, Interactable, Bankruptable{
    private Tile CURRENT_TILE;
    private String NAME;
    private double BALANCE;
    private Tile[] BOARD;
    private int currentPlace = 0;

    public Player(String name, int balance, Property startingTile, Tile[] board){
        NAME = name;
        BALANCE = balance;
        CURRENT_TILE = startingTile;
        BOARD = board;
    }

    @Override
    public Tile move(int diceRoll) {
        CURRENT_TILE = BOARD[(currentPlace += diceRoll) % BOARD.length];
        return CURRENT_TILE;
    }

    public double balance(){
        return BALANCE;
    }

    public String name(){
        return NAME;
    }

    @Override
    public void moveToJail() {
    }

    @Override
    public void receiveIncome(double income) {
        BALANCE += income;
    }

    @Override
    public double payRent(double rent) {
        BALANCE -= rent;
        return BALANCE;
    }

    @Override
    public double build(int cost) {
        BALANCE -= cost;
        return BALANCE;
    }

    @Override
    public double buyProperty(int cost) {
        BALANCE -= cost;
        return BALANCE;
    }

    @Override
    public double sellProperty(int saleValue) {
        BALANCE += saleValue;
        return BALANCE;
    }

    @Override
    public double mortgage(int mortgageValue) {
        BALANCE += mortgageValue;
        return BALANCE;
    }

    @Override
    public Tile Location() {
        return CURRENT_TILE;
    }

    /*
    Required as updates to BOARD are not global so this method will be called
    for all other players to sync up changes.
     */
    public void updateBoard(Tile[] updatedBoard){
        BOARD = updatedBoard;
    }

}
