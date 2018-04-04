package player;
import property.Property;

public interface Interactable{
    //Think of putting all the property interaction here:
    double pay(double amount);
    void receiveIncome(double income);
    double buyProperty(int cost);
    double sellProperty(int saleValue);
    double mortgage(int mortgageValue);
}
