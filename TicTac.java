import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class TicTac {
    private static char [][]grid;
    private static int size;
    public static char[][] intializeGrid(int n){
        grid=new char[n][n];
        size=n;
        for(char []row:grid)
            Arrays.fill(row,'-');
        return  grid;
    }
    public static void  printGrid(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
                System.out.print(grid[i][j]);
            System.out.println();
        }
    }
    public static String getPlayerName(String s){
        return  s.substring(2);
    }
    public static int getSpace(String command){
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)==' ')
                return i;
        }
        return -1;
    }
    public static boolean isValid(int row,int col){
        if(row<0 || row>=size || col <0 || col>=size )
            return  false;
        if(grid[row][col]!='-')
            return false;
        return true;
    }
    public static boolean isFilled(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[i][j]=='-')
                    return false;
            }
        }
        return true;
    }
    public static boolean hasWon(int row,int col,int turn){
        char playerPiece=turn%2==0 ? 'X' : 'O';
        boolean won=false;
        for(int i=0;i<size;i++){
            if(grid[row][i]!=playerPiece) {
                won = false;
                break;
            }
            else
                won=true;

        }
        if(won)
            return true;
        for(int i=0;i<size;i++){
            if(grid[i][col]!=playerPiece){
                won=false;
                break;
            }
            else{
                won=true;
            }
        }
        if(won)
            return true;
        for(int i=0;i<size;i++){
            if(grid[i][i]!=playerPiece){
                won=false;
                break;
            }
            won=true;
        }
        if(won)
            return true;
        return false;


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        intializeGrid(n);
        String player1=getPlayerName(sc.nextLine());
        String player2=getPlayerName(sc.nextLine());
        printGrid();
        int turn=0;
        while (true){
            String command=sc.nextLine();
            if(command.equals("exit"))
                break;
            int space=getSpace(command);
            int row=Integer.parseInt(command.substring(0,space))-1;
            int col=Integer.parseInt(command.substring(space+1))-1;
            if(isValid(row,col)){
                grid[row][col]=turn%2==0 ? 'X' : 'O';
                printGrid();
                if(hasWon(row,col,turn)){
                    String player=turn%2==0 ? player1 : player2;
                    System.out.println(player+" won the game");
                    break;
                }
                turn++;
            }
            else{
                System.out.println("Invalid Move");
            }
            if(isFilled()){
                System.out.println("Game Over");
                break;
            }
        }

    }
}
