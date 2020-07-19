
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> playerHand;
    private String status;

    public Player(String name){
        this.name = name;
        this.playerHand = new ArrayList<Card>();
        this.status = "Playing";
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
        if(this.hasAce()){
            if( (total + 10) < 22 ){
                total += 10;
                if(total == 21 & this.playerHand.size() == 2){
                    this.setStatus("Blackjack");
                }
            }


        }

        return total;
    }

    public void displayPlayersCurrentCards(){
        System.out.println(ConsoleColors.GREEN + this.getName() + ConsoleColors.RESET + ":");
        System.out.println("");
        for(Card card : playerHand){
            String clubColor = ConsoleColors.RED_BOLD;
            if(card.getSuit() == SuitType.CLUBS){clubColor = ConsoleColors.WHITE_BRIGHT;}
            if(card.getSuit() == SuitType.SPADES){clubColor = ConsoleColors.WHITE_BRIGHT;}
            System.out.println(card.getRank() + " of " + clubColor + ConsoleColors.BLACK_BACKGROUND + card.getSuit().getValue() + ConsoleColors.RESET);
        }
        System.out.println("");
        System.out.println(ConsoleColors.GREEN +  this.getName() + ConsoleColors.RESET + " has " + this.getHandCardValue() + " points.");
        if(this.getHandCardValue() > 21){
            System.out.println(ConsoleColors.RED_BOLD + "BUST!" + ConsoleColors.RESET);
        }
        System.out.println("");
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char decideNextMove(){
        Scanner scanner = new Scanner(System.in);
        char move = 'x';
        int times = 0;

        if(this.getName() == "Dealer"){
            if (this.getHandCardValue() < 17) {
                move = 'd';

            }

            if (this.getHandCardValue() <= 21 && this.getHandCardValue() > 16) {
                move = 's';
                this.setStatus("Stick");
            }

            if (this.getHandCardValue() > 21) {
                this.setStatus("Bust");
                System.out.println(ConsoleColors.RED_BRIGHT + "The Dealer is " + this.getStatus() + "!" + ConsoleColors.RESET);
            }

        }

                if(this.getName() != "Dealer") {

            if (this.getHandCardValue() < 21) {
                System.out.println(this.getName() + " you have " + this.getHandCardValue() + " points. Type [d] to draw another card or [s] to Stick.");
                move = scanner.next().charAt(0);
                while (move != 'd' & move != 's') {

                    times++;
                    if (times > 2) {
                        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "YOU'RE DOING THIS DELIBERATELY.");
                    }
                    if (move != 'h') {
                        System.out.println(ConsoleColors.RED_BOLD + move + " is not a valid choice" + ConsoleColors.RESET);
                        System.out.println("Please type [d] to Draw or [s] to Stick");
                        move = scanner.next().charAt(0);
                    }
                    if (move == 'h') {
                        this.displayPlayersCurrentCards();
                        System.out.println("Type [d] to Draw or [s] to Stick");
                        move = scanner.next().charAt(0);

                    }


                }
            } else if (this.getHandCardValue() == 21) {
                System.out.println(this.getName() + " you're on 21 points! You should probably stick. Type [s] to Stick or [d] to draw" + ConsoleColors.RED_BRIGHT + " (Don't Draw)." + ConsoleColors.RESET);
                move = scanner.next().charAt(0);

            } else if (this.getHandCardValue() > 21) {
                this.setStatus("Bust");
                System.out.println(ConsoleColors.RED_BRIGHT + this.getName() + "! You're bust!" + ConsoleColors.RESET);

            }

        }
                if(move == 's'){
                    this.setStatus("Stick");
                    System.out.println(ConsoleColors.GREEN + this.getName()  + " decided to stick on " + this.getHandCardValue() + " points" + ConsoleColors.RESET);
                }
        if(move == 'd'){
            System.out.println(ConsoleColors.GREEN + this.getName()  + " decided to draw another card " + ConsoleColors.RESET);
        }
                pressAnyKeyToContinue();
        return move;

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

    public boolean hasAce() {
        Boolean result = false;
        for(Card card : playerHand){
            if(card.getRank() == RankType.ACE ){
                result = true;
            }
        }
        return result;
    }
}
