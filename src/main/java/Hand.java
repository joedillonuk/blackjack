import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> playerHand;

    public Hand(){
        this.playerHand = new ArrayList<Card>();
    }

    public int getHandSize() {
        return this.playerHand.size();
    }

    public void receiveCard(Deck deck){
        Card card = deck.removeCard();
        playerHand.add(card);
    }
}
