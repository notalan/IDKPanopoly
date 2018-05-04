package chestChanceCards;

import cardDeck.Dealer;
import cardDeck.PlayableCard;
import events.CardGetPopUp;
import events.IncomeCardPopUp;
import events.QuestionPopup;
import player.Player;

import java.util.concurrent.TimeUnit;

/*
50% question card
10% income
10% deficit
30% gain a card from the card pile
 */

public class Chooser {

    private int CHOICE;
    private Player p;
    private Player[] P_LIST;
    public Chooser(int choice, Player pl, Player[] list){
        CHOICE = choice;
        p = pl;
        P_LIST = list;
    }

    public void callCard(){
        if (CHOICE > 50){
            new QuestionPopup(new QuestionCard(p).Question(), p);
        }
        else if (CHOICE > 40){
            IncomeCard I = new IncomeCard(p);
            if(p.getOwnedProperties().size() > 2){
                IncomeCardPopUp i = new IncomeCardPopUp(I.message(), I.getAmmount());
                try {
                    TimeUnit.SECONDS.sleep(3);
                }catch(Exception e){
                    e.printStackTrace();
                }
                i.dispose();
            }
            else{
                IncomeCardPopUp i = new IncomeCardPopUp("TAX REBATES / LOTTO / GRANDAD DIED - GET INHERITANCE", I.getAmmount());
                try {
                    TimeUnit.SECONDS.sleep(3);
                }catch(Exception e){
                    e.printStackTrace();
                }
                i.dispose();
            }
        }
//        else if (CHOICE > 30){
//            //deficit - card
//        }
        else{
            Dealer d = new Dealer(p, P_LIST);
            PlayableCard C = d.drawCard();
            p.CARDS.add(C);
            CardGetPopUp test = new CardGetPopUp(C);
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            test.dispose();
        }
    }
}
