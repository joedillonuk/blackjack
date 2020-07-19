public enum SuitType {
    HEARTS("\u2665"),
    DIAMONDS("\u2666"),
    SPADES("\u2660"),
    CLUBS("\u2663");

    private  final String value;

    SuitType(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
