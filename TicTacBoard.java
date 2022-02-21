import java.util.Arrays;

public class TicTacBoard {
    private char [][]board;
    private int size;
    private User []users;
    private int noOfUsers;
    TicTacBoard(int size,int noOfUsers){
        this.noOfUsers=noOfUsers;
        this.size=size;
        users=new User[noOfUsers];
        initializeBoard();
    }
    public  void initializeBoard(){
        board=new char[size][size];
        for(char []rows:board)
            Arrays.fill(rows,'-');
    }
    public void fillUserDetails(char piece,String name,int id){
        users[id]=new User(piece,name);
    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }
    public boolean isFilled(){
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(board[i][j]=='-')
                    return false;
            }
        }
        return true;
    }
    public boolean isValid(int row,int col){
        if(row<0 || col<0 || row>=size || col >=size)
            return false;
        if(board[row][col]!='-')
            return false;
        return true;
    }
    public void setPiece(int row,int col,int turn){
        board[row][col]=users[turn%noOfUsers].getPiece();
    }
    public boolean hasWinner(int row,int col,int turn){
        char playerPiece=users[turn%noOfUsers].getPiece();
        boolean win=true;
        for(int i=0;i<size;i++){
            if(board[row][i]!=playerPiece){
                win=false;
                break;
            }
        }
        if(win)
            return true;
        win=true;
        for(int i=0;i<size;i++){
            if(board[i][col]!=playerPiece){
                win=false;
                break;
            }
        }
        if(win)
            return true;
        win=true;
        for(int i=0;i<size;i++){
            if(board[i][i]!=playerPiece){
                win=false;
                break;
            }
        }
        if(win)
            return true;
        win=false;
        for(int i=size-1;i>=0;i--){
            if(board[i][i]!=playerPiece){
                win=false;
                break;
            }
        }
        if(win)
            return true;
        return false;
    }
    public String getWinner(int turn){
        return users[turn%noOfUsers].getName();
    }

}
