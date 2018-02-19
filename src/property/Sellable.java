package property;

public interface Sellable extends Identifiable {
    public boolean getSellable(); // Can you sell a house or hotel back to the bank i.e is there something to sell
    public int sellHouse(); // Sell a house back to the bank and add to balance
    public int sellHotel(); // Sell a hotel back to the bank and add to balance
}
