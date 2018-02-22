package property;
import player.Player;

public interface Ownable extends Identifiable {
    public boolean getOwnable(); // Is it possible the tile (cant buy jail, chance etc.)
    public Player owner(); // Returns the owners details
}
