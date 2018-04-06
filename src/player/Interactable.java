package player;
import property.Tile;

import java.util.ArrayList;

public interface Interactable{
    //Think of putting all the property interaction here:
    double pay(double amount);
    void receiveIncome(double income);
    double buyProperty(int cost);
    double sellProperty(int saleValue);
    double mortgage(int mortgageValue);
    ArrayList<Tile> getOwnedProperties();
    ArrayList<Tile> getMortProperties();
    void addProperty(Tile t);
    void addMortgage(Tile t);
    void removeProperty(Tile t);
    void removeMortgage(Tile t);
}
