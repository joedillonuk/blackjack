public class Runner {

    private int numberOfPlayers;

    private Game game;
    private Deck deck;
    private Player player;

    public static void main(String[] args) {
        Game game = new Game("Blackjack");
        System.out.println("Welcome! Let's play " + game.getName());

        //get number of players


        //get the names of each player


        //create the deck
        //shuffle the deck


        // give dealer a card
        // give each player a card


        // give deal another card
        // give each player another card



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
