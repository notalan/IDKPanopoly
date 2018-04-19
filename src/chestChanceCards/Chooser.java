package chestChanceCards;

import events.IncomeCardPopUp;
import events.QuestionPopup;
import player.Player;

/*
50% question card
10% income
10% deficit
30% gain a card from the card pile
 */

public class Chooser {

    private int CHOICE;
    private Player p;

    public Chooser(int choice, Player pl){
        CHOICE = choice;
        p = pl;
    }

    public void callCard(){
        if (CHOICE > 50){
            new QuestionPopup(new QuestionCard(p).Question(), p);
        }
        else/* if (CHOICE > 40)*/{
            IncomeCard I = new IncomeCard(p);
            if(p.getOwnedProperties().size() > 2){
                new IncomeCardPopUp(I.message(), I.getAmmount());
            }
            else{
                new IncomeCardPopUp("TAX REBATES / LOTTO / GRANDAD DIED - GET INHERITANCE", I.getAmmount());
            }
        }
//        else if (CHOICE > 30){
//            //deficit - card
//        }
//        else{
//            //get a card from the card pile
//        }
    }
}
