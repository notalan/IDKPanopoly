package property;

import player.Player;

public class Property extends Tile implements Buyable, Ownable, Mortgageable, Rentable, Tradeable {

    private double MortgagePrice; // How much you get back when you mortgage something
    private int tilePrice;
    private Player owner;
    double rentPrice;
    private boolean isMortgaged;

    public Property(String name, int xco, int yco, int price, double mortgagePrice, double rent) {
        tilePrice = price;
        MortgagePrice = mortgagePrice;
        rentPrice = rent;
        super.NAME = name;
        super.XCO = xco;
        super.YCO = yco;
    }

    @Override
    public int getPrice() {
        return tilePrice;
    }

    @Override
    public int buyTile(Player p) {
        owner = p;
        return 0;
    }

    @Override
    public boolean getMortgageable() {
        return isMortgaged;
    }

    @Override
    public void mortgageProperty() { isMortgaged = true; }

    @Override
    public void unMortgageProperty() {
        isMortgaged = false;
    }

    @Override
    public double getMortgageAmount() {
        return MortgagePrice;
    }

    @Override
    public Player owner() {
        return owner;
    }

    public boolean hasOwner(){return !(owner == null);}

    @Override
    public double getRent() {

        return rentPrice;
    }

    @Override
    public boolean getTradeable() {
        return false;
    }

    @Override
    public String transfer() {
        return null;
    }

}
