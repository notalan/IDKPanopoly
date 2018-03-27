import player.Player;
import property.*;
import twitterbotics.KnowledgeBaseModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;


class Initialiser {

    private  Random rand = new Random();

    private Property GO = new Property("GO", 0, 0, 0,0,0);

    private String kdir = "DATA/TSV Lists/";
    private KnowledgeBaseModule NOC = new KnowledgeBaseModule(kdir + "Veale's The NOC List.txt", 0);

    private String[] ENTRIES = new String[22];
    private int COUNT = 0;

    Player[] players(int num, String[] names, Tile[] board){
        Player[] playerArray = new Player[num];
        for(int i = 0; i < num; i++){
            playerArray[i] = new Player(names[i], 200, GO, board);
        }
        return playerArray;
    }

    Tile[] tiles(){
        Tile[] tileArray = new Tile[40];
        tileArray[0] = GO;
        tileArray[2] = new Property ("cardTile1", 0, 0, 0, 0, 0);
        tileArray[4] = new TaxTiles (0.1, 100, 200);
        tileArray[5] = new Property ("Train Station 1", 0, 0, 200, 100, 25);
        tileArray[7] = new Property ("cardTile2", 0, 0, 0, 0, 0);
        tileArray[10] = new Jail    ("Jail", 0, 0);
        tileArray[12] = new Property("Electric Company", 0, 0, 150, 75, 4/* *diceroll */);
        tileArray[15] = new Property("Train Station 2", 0, 0, 200, 100, 25);
        tileArray[17] = new Property("cardTile3", 0, 0, 0, 0, 0);
        tileArray[20] = new FreeParking("Free Parking", 0, 0);
        tileArray[22] = new Property("cardTile4", 0, 0, 0, 0, 0);
        tileArray[25] = new Property("Train Station 3", 0, 0, 200, 100, 25);
        tileArray[28] = new Property("Water Works", 0, 0, 150, 75, 4/* *diceroll */);
        tileArray[30] = new GoToJail("Go To Jail", 0, 0);
        tileArray[33] = new Property("cardTile5", 0, 0, 0, 0, 0);
        tileArray[35] = new Property("Train Station 4", 0, 0, 200, 100, 25);
        tileArray[36] = new Property("cardTile6", 0, 0, 0, 0, 0);
        tileArray[38] = new TaxTiles (0.1, 100, 200);

        /*
        try-catch needed as fileIO used to access NOC list.
        First while loop gets the 6 sets of 3 sized monopolies, pulled from NOC list.
        Second while loop gets the 2 sets of 2 sized monopolies, pulled from NOC list.
         */
        try {
            Vector<String> nameList;
            String currentName;
            int numOfSets = 0;
            while (numOfSets < 6) {
                nameList = getDomain();
                if (nameList.size() >= 3) {
                    for (int i = 0; i < 3; i++) {
                        currentName = generateNameFromDomain(nameList);
                        while (hasOccurredInEntries(currentName)) {//if name has already been taken, get a new one to avoid repeats
                            currentName = generateNameFromDomain(nameList);
                        }
                        System.out.println(currentName);
                        ENTRIES[COUNT++] = currentName;
                    }
                    numOfSets++;
                    System.out.println("-------");
                }
            }
            numOfSets = 0;
            while (numOfSets < 2) {
                nameList = getDomain();
                if (nameList.size() == 2) {
                    for (int i = 0; i < 2; i++) {
                        currentName = generateNameFromDomain(nameList);
                        while (hasOccurredInEntries(currentName)) {
                            currentName = generateNameFromDomain(nameList);
                        }
                        System.out.println(currentName);
                        ENTRIES[COUNT++] = currentName;
                    }
                    numOfSets++;
                    System.out.println("-------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tileArray[1] = new ImproveProperty(ENTRIES[20], 0, 0, 60, 50, 2, 50);
        tileArray[3] = new ImproveProperty(ENTRIES[21], 0, 0, 60, 50, 2, 50);

        tileArray[6] = new ImproveProperty(ENTRIES[0], 0, 0, 60, 50, 2, 50);
        tileArray[8] = new ImproveProperty(ENTRIES[1], 0, 0, 60, 50, 2, 50);
        tileArray[9] = new ImproveProperty(ENTRIES[2], 0, 0, 60, 50, 2, 50);

        tileArray[11] = new ImproveProperty(ENTRIES[3], 0, 0, 60, 50, 2, 50);
        tileArray[13] = new ImproveProperty(ENTRIES[4], 0, 0, 60, 50, 2, 50);
        tileArray[14] = new ImproveProperty(ENTRIES[5], 0, 0, 60, 50, 2, 50);

        tileArray[16] = new ImproveProperty(ENTRIES[6], 0, 0, 60, 50, 2, 50);
        tileArray[18] = new ImproveProperty(ENTRIES[7], 0, 0, 60, 50, 2, 50);
        tileArray[19] = new ImproveProperty(ENTRIES[8], 0, 0, 60, 50, 2, 50);

        tileArray[21] = new ImproveProperty(ENTRIES[9], 0, 0, 60, 50, 2, 50);
        tileArray[23] = new ImproveProperty(ENTRIES[10], 0, 0, 60, 50, 2, 50);
        tileArray[24] = new ImproveProperty(ENTRIES[11], 0, 0, 60, 50, 2, 50);

        tileArray[26] = new ImproveProperty(ENTRIES[12], 0, 0, 60, 50, 2, 50);
        tileArray[27] = new ImproveProperty(ENTRIES[13], 0, 0, 60, 50, 2, 50);
        tileArray[29] = new ImproveProperty(ENTRIES[14], 0, 0, 60, 50, 2, 50);

        tileArray[31] = new ImproveProperty(ENTRIES[15], 0, 0, 60, 50, 2, 50);
        tileArray[32] = new ImproveProperty(ENTRIES[16], 0, 0, 60, 50, 2, 50);
        tileArray[34] = new ImproveProperty(ENTRIES[17], 0, 0, 60, 50, 2, 50);

        tileArray[37] = new ImproveProperty(ENTRIES[18], 0, 0, 60, 50, 2, 50);
        tileArray[39] = new ImproveProperty(ENTRIES[19], 0, 0, 60, 50, 2, 50);
        return tileArray;
    }

    private boolean hasOccurredInEntries(String name){
        for(String entry: ENTRIES){ //check if it has appeared before/if it is already on the board
            if(name.equals(entry)){
                return true;    //Repeat Error
            }
        }
        return false;
    }

    /*
    Method finds a random entry in the NOC list (between 1 and 825 entries), takes the name from that entry,
    and derives the "domain" that name is a part of;
        e.g.    Hilary Clinton -> American Politics
                Elton John -> Music
                Batman -> DC Comics

     returns the vector containing all names associated with that domain.
     */
    private Vector<String> getDomain()  throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(kdir + "Veale's The NOC List.txt"));
        int lineNum = rand.nextInt(825) + 1; //num of lines in "Veale's The NOC List.txt", +1 to avoid field names
        for(int i = 0; i < lineNum - 1; i++) {
            br.readLine();
        }
        String randomPerson = br.readLine().split("\t")[0];
        String domain = NOC.getFirstValue("Domains", randomPerson);
        return NOC.getAllKeysWithFieldValue("Domains", domain);
    }

    /*
    Takes in a vector containing all names associated with a domain and returns a random name from the vector.
     */
    private String generateNameFromDomain(Vector<String> domain){
        return domain.elementAt(rand.nextInt(domain.size()));
    }

}
