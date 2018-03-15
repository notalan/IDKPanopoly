import player.Player;
import property.*;

public class Initialiser {
    private Property GO = new Property("GO", 0, 0, 0);

    public Player[] players(int num, String[] names, Tile[] board){
        Player[] playerArray = new Player[num];
        for(int i = 0; i < num; i++){
            playerArray[i] = new Player(names[i], 200, GO, board);
        }
        return playerArray;
    }

    public Tile[] tiles(){
        Tile[] tileArray = new Tile[3];
        tileArray[0] = GO;
        tileArray[1] = new ImproveProperty("Old Kent Road", 60, 20,
                2, 50);
        tileArray[2] = new Property("bus garage", 200, 50, 50);
        return tileArray;
    }


}
