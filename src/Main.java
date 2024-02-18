import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length;j++){
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        while(!gameover){
            printboard(board);
            System.out.println("Enter " + player + ":" );
            int row = input.nextInt();
            int column = input.nextInt();
            if(board[row][column] == ' '){
                board[row][column] = player;
            }
            else{
                System.out.println("wrong input");
                continue;
            }
            if(iswin(board,player)){
                gameover = true;
                System.out.println("game over");
                System.out.println(player + "won");
            }
            else{
                if(player == 'X'){
                    player = '0';
                }
                else{
                    player = 'X';
                }
            }

        }
    }
    public static void printboard(char[][] board){
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length;j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static boolean iswin(char[][] board , char player){
        //check rows
        for(int row = 0 ; row < board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        for(int column = 0 ; column < board[0].length;column++){
            if(board[0][column] == player && board[1][column] == player && board[2][column] == player){
                return true;
            }
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
}