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

    private Go GO = new Go("GO", 665, 665);

    private String kdir = "DATA/TSV Lists/";
    private KnowledgeBaseModule NOC = new KnowledgeBaseModule(kdir + "Veale's The NOC List.txt", 0);

    private String[] ENTRIES = new String[22];
    private int COUNT = 0;

    private String[] domainList = new String[8];

    private String [] STATION_NAMES = {"Interdimensional", "Trans-Plane", "Vaporwave", "L o n g", "Magnet", "Space",
            "Haunted", "Old-Timey", "Colony World"};
    private String [] STATION_TYPES = {"Parkway", "Line", "Subway", "Monorail", "Bullet Train", "Hyperrail", "Pentarail",
            "Northbound", "Southbound", "Eastbound", "WestBound", "Express"};

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
        tileArray[2] = new CardTIle ( 530,  665);
        tileArray[4] = new TaxTiles ("Income Tax", 410,640,100, 200,2,3); // 420, 665
        tileArray[7] = new CardTIle ( 250, 665);
        tileArray[10] = new Jail    ("Jail", 50, 665);
        tileArray[12] = new Property("Electric Company", 50, 530, 150, 75, 4/* *diceroll */);
        tileArray[17] = new CardTIle(50, 250);
        tileArray[20] = new FreeParking("Free Parking", 50, 60);
        tileArray[22] = new CardTIle(195, 50);
        tileArray[28] = new Property("Water Works", 530, 50, 150, 75, 4/* *diceroll */);
        tileArray[30] = new GoToJail("Go To Jail", 665, 50);
        tileArray[33] = new CardTIle( 665, 250);
        tileArray[36] = new CardTIle( 665, 420);
        tileArray[38] = new TaxTiles ("Luxury Tax", 633,510,100, 200,2,3/*,0*/); // 665, 530

        String[] stationName = new String[4];
        String[] stationlist = new String[8];
        String first, second;
        for(int i = 0; i < 4; i++){
            first = STATION_NAMES[rand.nextInt(STATION_NAMES.length)];
            while(hasOccurredIn(stationlist, first)){
                first = STATION_NAMES[rand.nextInt(STATION_NAMES.length)];
            }
            stationlist[i] = first;
            second = STATION_TYPES[rand.nextInt(STATION_TYPES.length)];
            while(hasOccurredIn(stationlist, second)){
                second = STATION_TYPES[rand.nextInt(STATION_TYPES.length)];
            }
            stationlist[i+4] = second;
            stationName[i] = first + " " + second;
            //System.out.println(stationName[i]);
        }

        tileArray[5] = new StationTile(stationName[0], 360, 665, domainList);
        tileArray[15] = new StationTile(stationName[1], 50, 360, domainList);
        tileArray[25] = new StationTile(stationName[2], 360, 50, domainList);
        tileArray[35] = new StationTile(stationName[3], 665, 360, domainList);

        /*
        try-catch needed as fileIO used to access NOC list.
        First while loop gets the 6 sets of 3 sized monopolies, pulled from NOC list.
        Second while loop gets the 2 sets of 2 sized monopolies, pulled from NOC list.
         */

        int domainCount = 0;
        try {
            Vector<String> nameList;
            String domain;
            String currentName;
            int numOfSets = 0;
            while (numOfSets < 6) {
                domain = getDomain();
                while(hasOccurredIn(domainList, domain)){
                    domain = getDomain();
                }
                boolean OccurredPreviously = false;
                nameList = NOC.getAllKeysWithFieldValue("Domains", domain);
                if (nameList.size() >= 3) {
                    for (String n : nameList) {
                        if (hasOccurredIn(ENTRIES, n)) {
                            OccurredPreviously = true;
                        }
                    }
                    if(!OccurredPreviously) {
                        domainList[domainCount++] = domain;
                        System.out.println(domain);
                        for (int i = 0; i < 3; i++) {
                            currentName = generateNameFromDomain(nameList);
                            while (hasOccurredIn(ENTRIES, currentName)) {//if name has already been taken, get a new one to avoid repeats
                                currentName = generateNameFromDomain(nameList);
                            }
                            ENTRIES[COUNT++] = currentName;
                        }
                        numOfSets++;
                        System.out.println("-------");
                    }
                }
            }
            numOfSets = 0;
            while (numOfSets < 2) {
                domain = getDomain();
                while(hasOccurredIn(domainList, domain)){
                    domain = getDomain();
                }
                boolean OccurredPreviously = false;
                nameList = NOC.getAllKeysWithFieldValue("Domains", domain);
                if (nameList.size() == 2) {
                    for (String n : nameList) {
                        if (hasOccurredIn(ENTRIES, n)) {
                            OccurredPreviously = true;
                        }
                    }
                    if(!OccurredPreviously) {
                        domainList[domainCount++] = domain;
                        System.out.println(domain);
                        for (int i = 0; i < 2; i++) {
                            currentName = nameList.elementAt(i);
                            ENTRIES[COUNT++] = currentName;
                        }
                        numOfSets++;
                        System.out.println("-------");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tileArray[1] = new ImproveProperty(ENTRIES[20], "Brown",585, 665, 60, 30, 2, 50); // browns
        tileArray[3] = new ImproveProperty(ENTRIES[21], "Brown",470, 665, 60, 30, 4, 50);

        tileArray[6] = new ImproveProperty(ENTRIES[0], "LBlue",305, 665, 100, 50, 6, 50); // light blue
        tileArray[8] = new ImproveProperty(ENTRIES[1], "LBlue",195, 665, 100, 50, 6, 50);
        tileArray[9] = new ImproveProperty(ENTRIES[2], "LBlue",140, 665, 120, 60, 8, 50);

        tileArray[11] = new ImproveProperty(ENTRIES[3], "Pink",50, 580, 140, 70, 10, 100); // pink
        tileArray[13] = new ImproveProperty(ENTRIES[4], "Pink",50, 470, 140, 70, 10, 100);
        tileArray[14] = new ImproveProperty(ENTRIES[5], "Pink",50, 420, 160, 80, 12, 100);

        tileArray[16] = new ImproveProperty(ENTRIES[6], "Orange", 50, 305, 180, 90, 14, 100); // orange
        tileArray[18] = new ImproveProperty(ENTRIES[7], "Orange",50, 190, 180, 90, 14, 100);
        tileArray[19] = new ImproveProperty(ENTRIES[8], "Orange",50, 140, 200, 100, 16, 100);

        tileArray[21] = new ImproveProperty(ENTRIES[9], "Red",140, 50, 220, 110, 18, 150); // red
        tileArray[23] = new ImproveProperty(ENTRIES[10], "Red",250, 50, 220, 110, 18, 150);
        tileArray[24] = new ImproveProperty(ENTRIES[11], "Red",305, 50, 240, 120, 20, 150);

        tileArray[26] = new ImproveProperty(ENTRIES[12], "Yellow",420, 50, 260, 130, 22, 150); // yellow
        tileArray[27] = new ImproveProperty(ENTRIES[13], "Yellow",470, 50, 260, 130, 22, 150);
        tileArray[29] = new ImproveProperty(ENTRIES[14], "Yellow",585, 50, 280, 140, 24, 150);

        tileArray[31] = new ImproveProperty(ENTRIES[15], "Green",665, 140, 300, 150, 26, 200); // green
        tileArray[32] = new ImproveProperty(ENTRIES[16], "Green",665, 190, 300, 150, 26, 200);
        tileArray[34] = new ImproveProperty(ENTRIES[17], "Green",665, 305, 320, 160, 28, 200);

        tileArray[37] = new ImproveProperty(ENTRIES[18], "DBlue",665, 470, 350, 175, 35, 200); // blue
        tileArray[39] = new ImproveProperty(ENTRIES[19], "Dblue",665, 580, 400, 200, 50, 200);
        return tileArray;
    }

    private boolean hasOccurredIn(String[] list, String name){
        for(String entry: list){ //check if it has appeared before/if it is already on the board
            if(name == null){
                return true;
            }
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
     */
    private String getDomain()  throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(kdir + "Veale's The NOC List.txt"));
        int lineNum = rand.nextInt(825) + 1; //num of lines in "Veale's The NOC List.txt", +1 to avoid field names
        for(int i = 0; i < lineNum - 1; i++) {
            br.readLine();
        }
        String randomPerson = br.readLine().split("\t")[0];
        return NOC.getFirstValue("Domains", randomPerson);
    }

    /*
    Takes in a vector containing all names associated with a domain and returns a random name from the vector.
     */
    private String generateNameFromDomain(Vector<String> domain){
        return domain.elementAt(rand.nextInt(domain.size()));
    }


}

