package property;

import java.util.Random;


public class StationTile extends Tile {

    private String[] DOMAIN_SET;

    public StationTile(String name, int xco, int yco, String[] domains){
        super.NAME = name;
        super.XCO = xco;
        super.YCO = yco;
        DOMAIN_SET = domains;
    }

    /*
        2% chance to be sent to jail
        15% chance to be sent to a tax tile - 10% luxury tax, 5% income Tax
        83% chance to be sent to a random monopoly set
    */
    public Object[] getDestination(){
        Random rand = new Random();
        Object[] tileInfo = new Object[2];
        int choice = rand.nextInt(100);
        if(choice <= 2){
            tileInfo[0] = 10;
            tileInfo[1] = "Jail";
            return tileInfo;
        }
        else if(choice < 17){
            if(choice < 12){
                tileInfo[0] = 38;
                tileInfo[1] = "Luxury Tax";
                return tileInfo;
            }
            else{
                tileInfo[0] = 4;
                tileInfo[1] = "Income Tax";
                return tileInfo;
            }
        }
        else {
            int selectedDomain = rand.nextInt(DOMAIN_SET.length) + 1;
            switch (selectedDomain) {
                case 1:
                    tileInfo[0] = 1;
                    tileInfo[1] = DOMAIN_SET[7];
                    return tileInfo;
                case 2:
                    tileInfo[0] = 6;
                    tileInfo[1] = DOMAIN_SET[0];
                    return tileInfo;
                case 3:
                    tileInfo[0] = 11;
                    tileInfo[1] = DOMAIN_SET[1];
                    return tileInfo;
                case 4:
                    tileInfo[0] = 16;
                    tileInfo[1] = DOMAIN_SET[2];
                    return tileInfo;
                case 5:
                    tileInfo[0] = 21;
                    tileInfo[1] = DOMAIN_SET[3];
                    return tileInfo;
                case 6:
                    tileInfo[0] = 26;
                    tileInfo[1] = DOMAIN_SET[4];
                    return tileInfo;
                case 7:
                    tileInfo[0] = 31;
                    tileInfo[1] = DOMAIN_SET[5];
                    return tileInfo;
                case 8:
                    tileInfo[0] = 37;
                    tileInfo[1] = DOMAIN_SET[6];
                    return tileInfo;
            }
            return tileInfo;
        }
    }

}
