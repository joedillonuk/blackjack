import java.util.Scanner;

public class Runner {

    private int numberOfPlayers;

    private Game game;
    private Deck deck;
    private Player player;
    private Hand hand;

    public static void main(String[] args) {
        Game game = new Game("Blackjack");
        System.out.println("Welcome! Let's play " + game.getName());

        //get number of players
        int numberOfPlayers = game.getNumberOfPlayers();

        System.out.println("Okay, let's play " + game.getName() + " with " + numberOfPlayers + " players!");
        System.out.println("");

        // Make the dealer a player
        Player player = new Player("Dealer");
        game.addPlayers(player);

        //get the names of each player
        for(int i = 0; i < numberOfPlayers; i++ ){
            System.out.println("Please type a name for player " + (i + 1));
//            Player player = new Player("temp");
            player = player.createPlayer();
            game.addPlayers(player);

        }
        System.out.println("");
        System.out.println("Okay! Let's play with " + (game.getAmountOfPlayers() - 1) + " players");


        //create the deck
        Deck deck = new Deck();
        deck.addAllCardsToDeck();
        System.out.println("The deck has " + deck.getDeckSize() + " cards");


        //shuffle the deck
        deck.shuffleDeck();
        System.out.println("That's them nice and shuffled");


        // give the hand a card
        Hand hand = new Hand();

        // give each player initial two-card hand
        game.dealCard(hand, deck);
        game.dealCard(hand, deck);

        System.out.println("");

        for(Player person : game.getPlayers()){
            game.pressAnyKeyToContinue();
//            System.out.print("\033[H\033[2J");
            game.displayPlayersCurrentHand(person);
        }

//        System.out.println(game.comparePlayerHands());
        game.pressAnyKeyToContinue();

        System.out.println("");
        System.out.println("");

        // give dealer another card
//        for(Player person : game.getPlayers()){
//            person.decideNextMove();
//
//
//            }


        // give each player who is still in the game another card
        while(game.anyonePlaying()) {
            for (Player person : game.getPlayers()) {

                if(person.getStatus() == "Playing") {
                    char move = person.decideNextMove();

                    if (person.getName() == "Dealer") {
                        if (move == 'd') {
                            game.dealSingleCard(hand, deck, person);
                            game.displayPlayersCurrentHand(person);

                        }
                    }

                    if (person.getName() != "Dealer") {
                        if(person.getStatus() == "Playing") {

                            game.dealSingleCard(hand, deck, person);
                            game.displayPlayersCurrentHand(person);
                        }
                    }
                }
            }
        }

        game.decideBlackjackWinner();


        // if dealer has <16 score, give dealer another card - should dealer be a Player object?

        //ask each player if they want another card - repeat until no players in Playing state
        // check player state conditional (add to Player object as string? Playing, Blackjack, Stick, Bust
        // (if player has blackjack already tell them not to take one?)



        // check highest hand value
        // if only one player has highest score, return Player object as winner
        // (???? should winner maybe be ArrayList? Check size for single winner?)

        // if winner.size() is 1 then declare that player as winner. Option to restart.

        // if more than one player in winners ArrayList has same high score:
        // if dealer is in winners ArrayList then return dealer as winner

        // compare hands of remaining players in line with blackjack rules/card hierarchy











    }
}
