package property;

public interface Auctionable extends Identifiable {
    public boolean getAuctionable(); // checks if the property has gone to auction i.e if the person has stated they dont want to buy it -> goes to auction
    public boolean beenBought(); // Has the tile been bought ? if not it goes to auction ^
    public int trackPrice(); // Keeps a track of the auction price
}
