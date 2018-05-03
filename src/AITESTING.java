
import AI.IntermediateAI;
import player.Player;
import property.*;


public class AITESTING {

    public static void main(String[] args) {
        Initialiser I = new Initialiser();
        Tile[] tileArray = I.tiles();

        Player p1 = new Player("john", 100, tileArray[0] ,tileArray);
        Player p2 = new Player("bill", 50, tileArray[0],tileArray);
        Player p3 = new Player("ted", 600, tileArray[0], tileArray);
        Player p4 = new Player("bob", 1000, tileArray[0], tileArray);
        Player[] arr = {p1, p2, p3, p4};
//        System.out.println("-----prop-----");
//        IntermediateAI PropertTest = new IntermediateAI("bob", arr, tileArray);
//        PropertTest.strategize();
//        PropertTest.tester(1);
//        PropertTest.act();
//
//        System.out.println("-----tax-----");
//        IntermediateAI TaxTest = new IntermediateAI("bob", arr, tileArray);
//        TaxTest.strategize();
//        TaxTest.tester(4);
//        TaxTest.act();
//
//        System.out.println("-----card-----");
//        IntermediateAI CardTest = new IntermediateAI("bob", arr, tileArray);
//        CardTest.strategize();
//        CardTest.tester(2);
//        CardTest.act();
//
//        System.out.println("-----shop-----");
//        IntermediateAI Shoptest = new IntermediateAI("bob", arr, tileArray);
//        Shoptest.strategize();
//        Shoptest.tester(12);
//        Shoptest.act();
//        Shoptest.strategize();


        IntermediateAI FirstTest = new IntermediateAI("bob", arr, tileArray);
        FirstTest.strategize();

    }
}
