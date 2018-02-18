package player;
import property.Property;

public interface Interactable{
    //Think of putting all the property interaction here:
    double payRent(double rent);
    Property trade(Property p /*player c*/);
    double build(int cost);
    double buyProperty(int cost);
    double sellProperty(int saleValue);
    double mortgage(int mortgageValue);
}