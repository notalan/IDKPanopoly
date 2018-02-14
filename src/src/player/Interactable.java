package player;

public interface Interactable extends Locatable{
    //Think of putting all the property interaction here:
    int payRent(double rent);
    //Property trade(Property p, player c);
    int build(int cost);
    //Property buyProperty(int cost);
    //Property sellProperty(int saleValue);
    //Property mortgage(int mortgage Value);
    //Property auction();///idk what to do with this rn
}
