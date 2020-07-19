import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private String name;
    private ArrayList<Player> players;
    private Player player;
    private ArrayList<Player> winners;

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

    public void dealSingleCard(Hand hand, Deck deck, Player player){
        hand.receiveCard(deck);
        player.receiveHand(hand);
    }

    public String comparePlayerHands() {
        String winner = null;
        int highest = 0;
        for (Player player : players) {
            if (highest == player.getHandCardValue()) {
//                System.out.println(winner);
                winner = "Sorry, it's a draw";
            } else if (player.getHandCardValue() > highest) {
//                System.out.println(winner);
                highest = player.getHandCardValue();
                winner = player.getName() + " is the winner, with a hand value of " + player.getHandCardValue() + "!!!";
//                System.out.println(winner);
            }
        }
            return winner;
        }

        public void decideBlackjackWinner(){
            winners = new ArrayList<Player>();
            int highest = 0;
            for(Player player : players){
                if(player.getStatus() != "Bust"){
                    if(player.getHandCardValue() >= highest) {
                        highest = player.getHandCardValue();
                    }
                }
            }

            for(Player player : players){
                if(player.getStatus() != "Bust"){
                    if(player.getHandCardValue() == highest) {
                        winners.add(player);
                    }
                }
            }

            if(winners.size() == 1){
                System.out.println(winners.get(0).getName() + " is the winner with a score of " + highest);
            }else if(winners.size() > 1){
                System.out.println("We have " + winners.size() + " players on " + highest + " points.");
                for(Player player : winners){
                    System.out.println(ConsoleColors.GREEN + player.getName() + ConsoleColors.RESET);
                }
            }

        }

        public int getNumberOfPlayers() {
            int players = 0;
            Scanner myObj = new Scanner(System.in);
            System.out.println("How many players?");
            System.out.println(ConsoleColors.BLUE_BRIGHT + "(please type a number between 1 and 7)" + ConsoleColors.RESET);
            while (!myObj.hasNextInt()) {
                System.out.println("That's not a number!");
                myObj.next();
            }
            players = myObj.nextInt();
            while(players <1 || players > 7){
                System.out.println(ConsoleColors.RED + "Sorry, you need to type a number between 1 and 7" + ConsoleColors.RESET);
                while (!myObj.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.println(ConsoleColors.BLUE_BRIGHT + "(please type a number between 1 and 7)" + ConsoleColors.RESET);

                    myObj.next();
                }

                players = myObj.nextInt();


            }
            return players;
        }

        public void displayPlayersCurrentHand(Player player) {
//            System.out.println(ConsoleColors.BLUE_BRIGHT + "Press enter" + "[" + "\u21A9" + "]" + " to see " + player.getName() +  "'s current hand." + ConsoleColors.RESET);
//            pressAnyKeyToContinue();
        player.displayPlayersCurrentCards();
        }

            public void pressAnyKeyToContinue()
            {
                System.out.println(ConsoleColors.BLUE_BRIGHT + "Press enter" + "[" + "\u21A9" + "]" + " to continue." + ConsoleColors.RESET);
                try
                {
                    System.in.read();
                }
                catch(Exception e)
                {}
            }

    public boolean anyonePlaying() {
        Boolean result = false;
        for(Player person : players){
            if(person.getStatus() == "Playing"){
                result = true;
            }
        }
        return result;
    }
}


