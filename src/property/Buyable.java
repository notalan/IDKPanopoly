package property;

public interface Buyable extends Identifiable {
    public boolean getBuyable(); // Checks if this tile is buyable eg. Jail isn't buyable. Returns true/false if its buyable or not
    public String getPrice(); // Get the price for this property
    public int buyTile(); // Buys the tile and deducts price from balance
}
