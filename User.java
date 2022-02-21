public class User {
    private char piece;
    private String userName;
    User(char piece,String name){
        this.piece=piece;
        this.userName=name;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }
}
