import java.util.Random;
import java.util.Scanner;

/*
 * Author: Uttam Bhattarai
 * Date: 12/10/2022
 * Updated: 12/13/2022
 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // We can start by making a 2d array
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        PrintBoard(board);
        while(true){
            PlayerInput(board,scan);
            if (GameStatus(board)){
                break;
            }
            PrintBoard(board);
            AiTurn(board);
            if (GameStatus(board)){
                break;
            }
            PrintBoard(board);
        }
        PrintBoard(board);

        scan.close();
    }

    private static boolean GameStatus(char[][] board) {
        if(hasContestantWon(board, 'X')) {
            PrintBoard(board);
            System.out.println("You win!, Congrats ;)");
            return true;
        }
        if(hasContestantWon(board, 'O')){
            PrintBoard(board);
            System.out.println("Ai wins!, Try again ;( ");
            return true;
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        System.out.println("This Game is a tie!, Try again!!");
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
            (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
            (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
        
            (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
            (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
            (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
        
            (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
            (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        }
    return false;
    }

    private static void AiTurn(char[][] board) {
        Random random = new Random();
        int AiMove;
        while(true){
            AiMove = random.nextInt(9)+1;
            if (CheckIfEmpty(board, AiMove)){
                break;
            }
        }
        System.out.println("Ai chose: "+AiMove);
        Move(board, Integer.toString(AiMove), 'O');
    }

    private static boolean CheckIfEmpty(char[][] board, int position){
        /*
         * We should use a switch statement rather than an if-else
         * We don't want the code to be really long. It should be simple and easy to follow.
         * easier to debug when mistakes happen
         */
        switch(position){
            case 1:
                return (board[0][0] == ' '); //Instead of doing if-else we can just use return to return boolean value
            case 2:
                return (board[0][1] == ' ');   
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                System.out.println("That position is taken, Try Again! ");
                return false;
            }
    }

    /*
     * PrintBoard method
     * easier to print board and less room for error
     */
    private static void PrintBoard(char[][]board){
        System.out.println(board[0][0]+ "|" + board[0][1]+ "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+ "|" + board[1][1]+ "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+ "|" + board[2][1]+ "|" + board[2][2]);

    }

    private static void PlayerInput(char[][] board, Scanner scan) {
        String input;
        while(true){
            System.out.print("please enter a position (1-9): ");
            input = scan.nextLine();
            if (CheckIfEmpty(board, Integer.parseInt(input))){
                break;
            } else{
                System.out.print("You entered "+input + " but this position is already taken! \n");
            }
        }
        Move(board, input, 'X');
    }

    private static void Move(char[][] board, String position, char symbol) {
        switch(position){
            case "1":board[0][0] = symbol;
                break;
            case "2":board[0][1] = symbol;
                break;
            case "3":board[0][2] = symbol;
                break;
            case "4":board[1][0] = symbol;
                break;
            case "5":board[1][1] = symbol;
                break;
            case "6":board[1][2] = symbol;
                break;
            case "7":board[2][0] = symbol;
                break;
            case "8":board[2][1] = symbol;
                break;
            case "9":board[2][2] = symbol;
                break;
            default:
                System.out.println("Bad input. Please enter a number (1-9)");
        }
    }
}

