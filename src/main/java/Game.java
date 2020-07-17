import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private String name;
    private ArrayList<Player> players;

    public Game(String name){
        this.name = name;
        this.players = new ArrayList<Player>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getAmountOfPlayers(){
        return this.players.size();
    }

    public void addPlayers(Player player){
        this.players.add(player);
    }

    public void dealCard(Hand hand, Deck deck){
        for (Player player : players){
            hand.receiveCard(deck);
            player.receiveHand(hand);
        }
    }

    public String comparePlayerHands() {
        String winner = null;
        int highest = 0;
        for (Player player : players) {
            if (highest == player.getHandCardValue()) {
                System.out.println(winner);
                winner = "Sorry, it's a draw";
            } else if (player.getHandCardValue() > highest) {
                System.out.println(winner);
                highest = player.getHandCardValue();
                winner = player.getName() + " is the winner, with a hand value of " + player.getHandCardValue() + "!!!";
                System.out.println(winner);
            }
        }
            return winner;
        }
    }


