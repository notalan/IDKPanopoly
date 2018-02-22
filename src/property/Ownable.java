package property;
import player.Player;

public interface Ownable extends Identifiable {
    public Player owner(); // Returns the owners details
}
