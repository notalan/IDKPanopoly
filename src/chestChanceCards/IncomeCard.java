package chestChanceCards;

import player.Player;
import property.Tile;
import transactions.IncomeTransaction;
import twitterbotics.KnowledgeBaseModule;

import java.util.ArrayList;
import java.util.Random;


public class IncomeCard extends Card{

    private KnowledgeBaseModule NOC = new KnowledgeBaseModule(kdir + "Veale's The NOC List.txt", 0);
    private KnowledgeBaseModule TAL = new KnowledgeBaseModule(kdir + "Veale's Typical Activities.txt", 0);
    private KnowledgeBaseModule L = new KnowledgeBaseModule(kdir + "Veale's location listing.txt", 0);
    private Random rand = new Random();
    private double ammount;
    public IncomeCard(Player player){
        super(player);
        ammount = 40 + rand.nextInt(30);
        new IncomeTransaction(PLAYER, ammount);
    }

    public String message(){
        if(PLAYER.getOwnedProperties().size() > 2){
            ArrayList<Tile> props = PLAYER.getOwnedProperties();
            int tileChoice = rand.nextInt(props.size());
            String name = props.get(tileChoice).getIdentifier();

            String typicalActivity = NOC.getFirstValue("Typical Activity", name);
            String location = TAL.getFirstValue("Setting", typicalActivity);
            String prep = L.getFirstValue("Preposition", location);
            String det = L.getFirstValue("Determiner", location);
            return "You find yourself " + prep + " " + det + " " + location + " facing "
                    + name + ", " + getPronoun(name) + " thanks you for your patronage!";
        }
        return "";
    }

    private String getPronoun(String name){
        String gender = NOC.getFirstValue("Gender", name);
        if(gender.equals("male")){
            return "he";
        }
        else if(gender.equals("female")){
            return "she";
        }
        else{
            return "they";
        }
    }

    public double getAmmount() {
        return ammount;
    }
}
