package chestChanceCards;

import player.Player;
import property.ImproveProperty;
import property.Tile;

public class CardPileTesting {
    public static void main(String[] args) {
        Player p = new Player("bob", 100, new Tile(), new Tile[10]);
        String[] sample = {"Daniel Day-Lewis", "Tina Fey", "Abraham Lincoln", "John Wilkes Booth", "Adam Sandler"};
        for (int i = 0; i < 5; i++) {
            p.addProperty(new ImproveProperty(sample[i], "", 0, 0, 10, 10, 5, 50));
        }
        new Chooser(45, p, new Player[]{}).callCard();
    }
}
