package AI;

import cardDeck.*;
import chestChanceCards.IncomeCard;
import chestChanceCards.QuestionCard;
import dice.Dice;
import events.*;
import player.Player;
import property.*;
import transactions.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IntermediateAI implements AIplayer {
    private ArrayList<TileHeuristic> tileLookupTable = new ArrayList<>();
    private Player[] otherPlayers;
    private Tile[] BOARD;
    private Player SELF;
    private Tile currentTile;
    private int HeuristicAve;
    double playerAverage;

    private Player First_Place, Last_Place;
    public IntermediateAI(String name, Player[] pList, Tile[] board){
        otherPlayers = pList;
        BOARD = board;
        initialiseTable();
        SELF = new Player(name, 1500, BOARD[0], BOARD);
    }

    /*
    Constructor used to manage Auctions
     */
    public IntermediateAI(Player player, Player[] pList){
        otherPlayers = pList;
        updater(player);
    }

    @Override
    public void strategize() {
        //update tileHeuristic table to include any changes made to board during other player turns.
        updateTable();

        //find average heuristic value of the board
        HeuristicAve = 0;
        for(TileHeuristic th : tileLookupTable){
            HeuristicAve += th.Heuristic;
        }
        HeuristicAve = HeuristicAve/tileLookupTable.size();

        //estimate monetary position in game
        playerAverage = 0;
        for(Player p : otherPlayers){
            playerAverage += p.balance();
        }
        playerAverage = playerAverage/otherPlayers.length;
        System.out.println(playerAverage);

        double last = 10000;
        Player lastPlace = SELF;
        for (Player p : otherPlayers) {
            if (p.balance() <= last) {
                last = p.balance();
                lastPlace = p;
            }
        }
        Last_Place = lastPlace;

        double lead = 0;
        Player leader = SELF;
        for (Player p : otherPlayers) {
            if (p.balance() >= lead) {
                lead = p.balance();
                leader = p;
            }
        }
        First_Place = leader;

        //take inventory of cards in hand
        boolean haveCommCard = false;
        boolean haveCapCard = false;
        boolean haveFYFCard = false;
        boolean haveHouseCard = false;

        for(PlayableCard c : SELF.CARDS){
            if(c instanceof CommunistCard)
                haveCommCard = true;
            if(c instanceof CapitalistCard)
                haveCapCard = true;
            if(c instanceof FYFCard)
                haveFYFCard = true;
            if(c instanceof FreeHouseCard)
                haveHouseCard = true;
        }
        System.out.println(haveCommCard + "," + haveCapCard + "," + haveFYFCard + "," + haveHouseCard);

        //process results
        if(SELF.balance() > playerAverage){
            System.out.println("ahead of curve");
            //un-mortgaging, cards, leave jail
            if(SELF.isJailed()){
                new ExpenditureTransaction(SELF, 50);
                SELF.freeFromChains();
                System.out.println("set self free");
            }
            /*
            un-mort most valuable mort property
             */
            if (SELF.getMortProperties().size() > 2) {
                int max = 0;
                Tile toRestore = null;
                int temp;
                for (Tile T : SELF.getMortProperties()) {
                    if (max < (temp = tileLookupTable.get(tileLookupTable.indexOf((T))).Heuristic)) {
                        max = temp;
                        toRestore = tileLookupTable.get(tileLookupTable.indexOf(T)).T;
                    }
                }
                if (toRestore != null) {
                    new UnmortgageTransaction(SELF, (Property) toRestore);
                }
            }
            if (haveFYFCard) {
                useFYF(Last_Place);
            }

        }
        else {
            //stay in jail, if not in jail -> take turn
            System.out.println("behind curve");
            if(!SELF.isJailed()) {
                //find lowest priority property:
                if (SELF.getOwnedProperties().size() > 3) {
                    int min = 100;
                    Tile toRemove = null;
                    int temp;
                    for(TileHeuristic th : tileLookupTable){
                        for(Tile I : SELF.getOwnedProperties()) {
                            if (th.T.equals(I)) {
                                if (th.Heuristic <= min) {
                                    toRemove = I;
                                    min = th.Heuristic;
                                }
                            }
                        }
                    }
                    if (toRemove != null) {
                        new MortgageTransaction(SELF, (Property) toRemove);
                    }
                }
                //CRIMSON PROTOCOL
                if (haveCommCard) {
                    int i = 0;
                    while (SELF.balance() > 0 && SELF.getMortProperties().size() > 0) {
                        new UnmortgageTransaction(SELF, (Property) SELF.getMortProperties().get(i));
                        i++;
                    }
                    PlayableCard C = null;
                    for (PlayableCard c : SELF.CARDS) {
                        if (c instanceof CommunistCard) {
                            c.use();
                            C = c;
                            break;
                        }
                    }
                    SELF.CARDS.remove(C);
                }
                //END CRIMSON PROTOCOL

                if (haveFYFCard) {
                    useFYF(First_Place);
                }
            }
            //else stay in jail
        }
        if (haveHouseCard) {
            //find anything monopolised, if multiple then pick highest heuristic
            ArrayList<ImproveProperty> monopoliedProps = new ArrayList<>();
            for(Tile I : SELF.getOwnedProperties()){
                if(((ImproveProperty)I).monopolyCheck() && ((ImproveProperty)I).getConstructable()){
                    monopoliedProps.add((ImproveProperty)I);
                }
            }
            //if a house can be built on the best tile, build it and remove the card
            if(monopoliedProps.size() > 0) {
                if (getPriorityTile(monopoliedProps).getConstructable()) {
                    getPriorityTile(monopoliedProps).buildHouse();
                    PlayableCard C = null;
                    for (PlayableCard c : SELF.CARDS) {
                        if (c instanceof FreeHouseCard) {
                            C = c;
                            break;
                        }
                    }
                    SELF.CARDS.remove(C);
                }
            }
        }

    }

    @Override
    public void roll() {
        if(SELF.isJailed()){
            int first = new Dice().rollDice(1, 6);
            int second = new Dice().rollDice(1, 6);
            if(first == second) {
                SELF.freeFromChains();
            }
        }
        else {
            currentTile = SELF.move(new Dice().rollDice(2, 6));
        }
        System.out.println(currentTile);
    }

    @Override
    public void act() {
        if(currentTile instanceof ImproveProperty){
            if(((ImproveProperty) currentTile).hasOwner() && !((ImproveProperty) currentTile).owner().equals(SELF)){
                new RentTransaction(SELF, (ImproveProperty)currentTile);
            }
            else if(SELF.balance() >= playerAverage) {
                for (TileHeuristic th : tileLookupTable) {
                    if (th.T.equals(currentTile)) {
                        if (th.Heuristic >= HeuristicAve)
                            new BuyTransaction(SELF, (ImproveProperty) currentTile);
                        break;
                    }
                }
                if (((ImproveProperty) currentTile).monopolyCheck()
                        && ((ImproveProperty) currentTile).owner().equals(SELF)) {
                    new BuildHouseTransaction(SELF, (ImproveProperty) currentTile);
                }
            }
        }
        else if(currentTile instanceof StationTile){
            new ChooseEvent(SELF, currentTile, otherPlayers);
            System.out.println(SELF.balance());
        }
        else if(currentTile instanceof TaxTiles){
            double taxtype = ((TaxTiles) currentTile).getTypeOfTax();
            if(taxtype < ((TaxTiles) currentTile).getFlatIncomeTaxAmount()){
                new transactions.IncomeTaxTransaction(SELF, (TaxTiles)currentTile, false, (FreeParking)BOARD[20]);
                System.out.println("income " + SELF.balance());
            }
            else if(taxtype > ((TaxTiles) currentTile).getIncomeTaxPercentage()
                    && taxtype < ((TaxTiles) currentTile).getFlatLuxaryTaxAmount()){
                new transactions.IncomeTaxTransaction(SELF, (TaxTiles)currentTile, true, (FreeParking)BOARD[20]);
                System.out.println("flatIncome " + SELF.balance());
            }
            else{
                new transactions.LuxuryTransaction(SELF, (TaxTiles)currentTile, (FreeParking)BOARD[20]);
                System.out.println("Luxury " + SELF.balance());
            }
        }
        else if(currentTile instanceof CardTIle){
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice > 50){
                QuestionPopup q = new QuestionPopup(new QuestionCard(SELF).Question(), SELF);
                try {
                    TimeUnit.SECONDS.sleep(3);
                }catch(Exception e){
                    e.printStackTrace();
                }
                q.dispose();
                new IncomeTransaction(SELF, 50);
                CorrectPopUp c = new CorrectPopUp();
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch(Exception e){
                    e.printStackTrace();
                }
                c.dispose();
            }
            else if (choice > 40){
                IncomeCard I = new IncomeCard(SELF);
                if(SELF.getOwnedProperties().size() > 2){
                    IncomeCardPopUp i = new IncomeCardPopUp(I.message(), I.getAmmount());
                }
                else{
                    IncomeCardPopUp i = new IncomeCardPopUp("TAX REBATES / LOTTO / GRANDAD DIED - GET INHERITANCE", I.getAmmount());
                }
            }
            else{
                Dealer d = new Dealer(SELF, otherPlayers);
                SELF.CARDS.add(d.drawCard());
            }
        }
        else if(currentTile instanceof Jail){
            //just visiting?
            SELF.moveToJail();
        }
        else if(currentTile instanceof GoToJail){
            SELF.moveToJail();
        }
        else if(currentTile instanceof FreeParking){
            new IncomeTransaction(SELF, ((FreeParking) currentTile).freeParkingPool);
            ((FreeParking) currentTile).freeParkingPool = 0;
        }
        else if(currentTile instanceof Go){
            /**
             * TO DO
             */
        }
        else if(currentTile instanceof MiniGame){
            /**
             * TO DO
             */
        }
        else if(currentTile instanceof Shop){
            ShopEvent S = new ShopEvent(SELF, otherPlayers);
            PlayableCard[] c = S.getCards();
            double[] values = S.getValues();
            for(int i = 0; i < 2; i++){
                if(c[i] instanceof CommunistCard && (SELF.equals(First_Place) || SELF.equals(Last_Place))){
                    SELF.CARDS.add(c[i]);
                    new ExpenditureTransaction(SELF, values[i]);
                }
                if(c[i] instanceof CapitalistCard && values[i] < c[i].getWorth()){
                    SELF.CARDS.add(c[i]);
                    new ExpenditureTransaction(SELF, values[i]);
                }
                if(c[i] instanceof FYFCard){
                    SELF.CARDS.add(c[i]);
                    new ExpenditureTransaction(SELF, values[i]);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch(Exception e){
                e.printStackTrace();
            }
            S.getFrame().dispose();
            System.out.println(SELF.balance());
        }
    }

    private void initialiseTable(){
        for(Tile t: BOARD){
            if(t instanceof ImproveProperty)
                tileLookupTable.add(new TileHeuristic(t));
        }
    }

    private void updateTable(){
        for(TileHeuristic th: tileLookupTable){
            th.setHeuristic(SELF);
        }
    }

    private void useFYF(Player target){
        PlayableCard C = null;
        for (PlayableCard c : SELF.CARDS) {
            if (c instanceof FYFCard) {
                new ExpenditureTransaction(target, 200);
                new IncomeTransaction(SELF, 200);
                C = c;
                break;
            }
        }//should use all FYF cards, unintentional but think should be kept
        SELF.CARDS.remove(C);
    }

    private ImproveProperty getPriorityTile(ArrayList<ImproveProperty> set){
        ImproveProperty best = set.get(0);
        int max = 0;
        for(ImproveProperty I : set){
            for(TileHeuristic th : tileLookupTable){
                if(th.T.equals(I)){
                    if(th.Heuristic >= max){
                        best = I;
                        max = tileLookupTable.get(tileLookupTable.indexOf(I)).Heuristic;
                    }
                }
            }
        }

        return best;
    }

    public double auctionStrategise(Tile auctionTarget, double highestBid){
        TileHeuristic th = new TileHeuristic(auctionTarget);
        th.setHeuristic(SELF);
        System.out.println(th.Heuristic);
        HeuristicAve  = 250; // median estimate
        if(th.Heuristic >= HeuristicAve && highestBid < ((ImproveProperty)auctionTarget).getPrice() * 0.6){
            playerAverage = 0;
            for(Player p : otherPlayers){
                playerAverage += p.balance();
            }
            playerAverage = playerAverage/otherPlayers.length;
            if(SELF.balance() > playerAverage)
                return highestBid + 5;
            else{
                return 0.0;
            }
        }
        return 0.0;
    }

    public Player findInnerSelf(){
        return SELF;
    }

    public void updater(Player p){
        SELF = p;
    }

    public void tester(int x){
        currentTile = SELF.move(x);
    }

}
