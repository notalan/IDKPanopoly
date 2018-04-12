package player;
import property.*;

import java.util.ArrayList;

public class Player implements Locatable, Interactable, Bankruptable{
    private Tile CURRENT_TILE;
    private String NAME;
    private double BALANCE;
    private Tile[] BOARD;
    public int currentPlace = 0;
    private boolean IN_JAIL;
    private ArrayList<Tile> OWNED_PROPERTIES = new ArrayList<>();
    private ArrayList<Tile>  MORTGAGED_PROPERTIES = new ArrayList<>();

    public Player(String name, int balance, Tile startingTile, Tile[] board){
        NAME = name;
        BALANCE = balance;
        CURRENT_TILE = startingTile;
        BOARD = board;
<<<<<<< Updated upstream
        boolean IN_JAIL = false;
    }

    @Override
    public ArrayList<Tile> getOwnedProperties() {
        return OWNED_PROPERTIES;
    }

    @Override
    public void addProperty(Tile t) {
        OWNED_PROPERTIES.add(t);
    }

    @Override
    public void addMortgage(Tile t) {
        MORTGAGED_PROPERTIES.add(t);
    }

    @Override
    public void removeProperty(Tile t) {
        OWNED_PROPERTIES.remove(t);
    }

    @Override
    public void removeMortgage(Tile t) {
        MORTGAGED_PROPERTIES.remove(t);
    }

    @Override
    public ArrayList<Tile> getMortProperties() {
        return MORTGAGED_PROPERTIES;
=======
        boolean inJail = false;
>>>>>>> Stashed changes
    }

    @Override
    public Tile move(int diceRoll) {
        currentPlace = (currentPlace + diceRoll) % BOARD.length;
        CURRENT_TILE = BOARD[currentPlace];
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
        CURRENT_TILE = BOARD[10];
        currentPlace = 10;
    }

    @Override
    public boolean isJailed() {
        return IN_JAIL;
    }

    @Override
    public void receiveIncome(double income) {
        BALANCE += income;
    }

    @Override
    public double buyProperty(int cost) {
        return 0;
    }

    @Override
    public double pay(double amount){
        BALANCE -= amount;
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
