import java.util.Scanner;

public class TicTacToe {
    private static int size;
    private static int noOfUsers;
    private static String winner;
    TicTacToe(){
        this.size=0;
        this.noOfUsers=0;
        this.winner="";
    }
    public static int getSpace(String command){
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)==' ')
                return i;
        }
        return -1;
    }

    public static String getWinner() {
        return winner;
    }

    public static void setWinner(String winner) {
        TicTacToe.winner = winner;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        size=sc.nextInt();
        noOfUsers=sc.nextInt();
        String garbage=sc.nextLine();
        TicTacBoard ticTacBoard=new TicTacBoard(size,noOfUsers);
        int userCount=0;
        while (userCount<noOfUsers){
            String userDetail=sc.nextLine();
            ticTacBoard.fillUserDetails(userDetail.charAt(0),userDetail.substring(2),userCount);
            userCount++;
        }
        int turn=0;
        ticTacBoard.printBoard();
        while (true){
            String command= sc.nextLine();
            if(command.equals("exit")){
                break;
            }
            int space=getSpace(command);
            int row=Integer.parseInt(command.substring(0,space))-1;
            int col=Integer.parseInt(command.substring(space+1))-1;
            if(ticTacBoard.isValid(row,col)){
                ticTacBoard.setPiece(row,col,turn);
                ticTacBoard.printBoard();
                if(ticTacBoard.hasWinner(row,col,turn)){
                    setWinner(ticTacBoard.getWinner(turn));
                    System.out.println(getWinner()+" won the game");
                    break;
                }
                turn++;
            }
            else{
                System.out.println("Invalid Move");
            }
            if(ticTacBoard.isFilled()){
                System.out.println("Game Over");
                break;
            }

        }

    }
}
