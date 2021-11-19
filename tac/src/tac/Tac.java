
package tac;
import java.util.*;

public class Tac {

    static String[] board;
    static String turn;
        
    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;
  
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            
            if (line.equals("XXX")) {
                return "X";
            }
              
            
            else if (line.equals("OOO")) {
                return "O";
            }
        }
          /*
        per sapere chi ha vinto
        */
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
  
       
        System.out.println(
            " turno "
            + turn + " in:");
   
             return null;
    }
    
    static void printBoard()
    {
     
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");

        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
       
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
   
    }
  
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
  
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
  
        System.out.println("Tic Tac Toe.");
        printBoard();
  
        System.out.println(
            "X inizia");
  /*
        while non ce vincitore ottiene un nuovo numero dal'utente
        */
        while (winner == null) {
            int numInput;
            

            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "non si puo,rentri numero:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "non si puo rentri un numero");
                continue;
            }
            
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
  
                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }
  
                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                    "prova un'altro numero");
            }
        }
/*
        ignores if it is upper case or lower case
        */
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                "nessuno ha vinto .");
        }
        

        else {
            System.out.println(
                "Congratulatzione! " + winner
                + " ha vinto grazie per giocare.");
        }
    }
}