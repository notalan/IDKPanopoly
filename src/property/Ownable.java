package property;

public interface Ownable extends Identifiable {
    public boolean getOwnable(); // Is it possible the tile (cant buy jail, chance etc.)
    public String owner(); // Returns the owners details
}
