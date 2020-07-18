import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> playerHand;

    public Player(String name){
        this.name = name;
        this.playerHand = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void receiveCard(Card card){
        playerHand.add(card);
    }

    public void receiveHand(Hand hand){
        Card card = hand.removeCard();
        playerHand.add(card);
    }

    public int getPlayerHandSize(){
        return this.playerHand.size();
    }

    public int getHandCardValue(){
        int total = 0;
        for (Card card : this.playerHand){
            total += card.getValueFromEnum();
        }
        return total;
    }

    public String getPlayerNameFromScanner(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }

    public Player createPlayer(){
        String name = getPlayerNameFromScanner();
        return new Player(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
