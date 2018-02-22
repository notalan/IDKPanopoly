package property;

import player.Player;

public class Property extends Tile implements Buyable, Ownable, Mortgageable, Rentable{


    double mortgagePrice; // How much you get back when you mortgage something
    int tilePrice;
    Player owner;
    double rentPrice;
    boolean isMortgaged;

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
    public void mortgageProperty() {
         isMortgaged = true;

    }

    @Override
    public void unMortgageProperty() {
        isMortgaged = false;
    }

    @Override
    public double getMortgageAmount() {
        return mortgagePrice;
    }

    @Override
    public Player owner() {
        return owner;
    }

    @Override
    public double getRent() {
        return rentPrice;
    }
}
