package property;

public interface Constructable extends Ownable {
    public boolean getConstructable(); // Is there room to build improvements on this tile (4 houses max and 1 hotel)
    public int countHouses(); // Keeps track of how many houses are built
    public int countHotels(); // Keeps track of how many hotels are built
    public void buildHouse();
    public void buildHotel();
}
