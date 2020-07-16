import java.util.Arrays;

public class Card {

    private SuitType suit;
    private RankType rank;

    public Card(SuitType suit, RankType rank){
        this.suit = suit;
        this.rank = rank;
    }

    public SuitType getSuit() {
        return this.suit;
    }

    public RankType getRank() {
        return this.rank;
    }

    public int getValueFromEnum(){
//        System.out.println(Arrays.toString(SuitType.values()));
        return this.rank.getValue();
    }




}
