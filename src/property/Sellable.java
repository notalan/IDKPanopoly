package property;

public interface Sellable extends Identifiable {
    public boolean getSellable(); // Can you sell a house or hotel back to the bank i.e is there something to sell
    public void sellHouse(); // Sell a house back to the bank and add to balance
    public void sellHotel(); // Sell a hotel back to the bank and add to balance
}
