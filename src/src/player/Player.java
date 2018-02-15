package player;
import property.Property;
import java.util.ArrayList;

public class Player implements Bankruptable{
    public Property CURRENT_TILE;
    private String NAME;
    private double BALANCE;
    void Player(String name, int balance, Property startingTile){
        NAME = name;
        BALANCE = balance;
        CURRENT_TILE = startingTile;
    }

    @Override
    public Property move(int diceRoll) {
        return null;
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
    public double payRent(double rent) {
        BALANCE -= rent;
        return BALANCE;
    }

    @Override
    public Property trade(Property p) {
        return null;
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
    public Property Location() {
        return CURRENT_TILE;
    }

    @Override
    public ArrayList<Property> properties() {
        return null;
    }
}
