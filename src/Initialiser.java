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

    private String[] ENTRIES = new String[23];
    private int COUNT = 0;

    Player[] players(int num, String[] names, Tile[] board){
        Player[] playerArray = new Player[num];
        for(int i = 0; i < num; i++){
            playerArray[i] = new Player(names[i], 200, GO, board);
        }
        return playerArray;
    }

    Tile[] tiles(){
        Tile[] tileArray = new Tile[3];
        tileArray[0] = GO;
        tileArray[1] = new ImproveProperty("Old Kent Road", 60, 20,
                2, 50,0,0);
        tileArray[2] = new Property("bus garage", 200, 50, 50,0,0);

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
        /*
        e.g use:
        TileArray[1] = new ImproveProperty(ENTRIES[0], 60, 20,
                2, 50);
        TileArray[3] = new ImproveProperty(ENTRIES[1], 60, 20,
                2, 50)
                ...
         */

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
