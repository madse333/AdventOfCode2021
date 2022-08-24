import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GiantSquidPart1 {

    public static String[] drawNumber;
    public static int winningNumber;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input4.txt"));
        drawNumber = scan.nextLine().split(",");
        ArrayList<int[][]> boards = new ArrayList<>();
        while (scan.hasNext()){
            int[][] board = new int[5][5];
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board.length; j++){
                    board[i][j] = scan.nextInt();
                }
            }
            boards.add(board);
        }

        int[][] winningBoard = getWinningBoard(boards);
        int sum = 0;
        for (int i = 0; i < winningBoard.length; i++){
            for (int j = 0; j < winningBoard.length; j++){
                if (winningBoard[i][j] != -1){
                    sum += winningBoard[i][j];
                }
                System.out.print(winningBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Sum of unmarked numbers: " + sum);
        System.out.println();
        System.out.println("Winning number is: " + winningNumber);
        System.out.println();
        System.out.println("Total sum of points: " + sum * winningNumber);
    }


    private static File getFile(String uri){
        File file = new File(uri);
        return file;
    }

    public static int[][] getWinningBoard(ArrayList<int[][]> boards){
        return getWinningBOard(boards,0);
    }

    private static int[][] getWinningBOard(ArrayList<int[][]> boards, int nextNumber){
        ArrayList<int[][]> tempBoards = boards;
        for (int[][] board : tempBoards){
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board.length; j++){
                    if (board[i][j] == Integer.parseInt(drawNumber[nextNumber])){
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int[][] board : tempBoards){
            int countRow = 0;
            int countCol = 0;
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board.length; j++){
                    if (board[i][j] == -1){
                        countRow++;
                    }
                    else{
                        countRow = 0;
                    }
                    if (board[j][i] == -1){
                        countCol++;
                    }
                    else{
                        countCol = 0;
                    }
                    if (countCol == 5 || countRow == 5){
                        winningNumber = Integer.parseInt(drawNumber[nextNumber]);
                        return board;
                    }
                }
            }
        }
        return getWinningBOard(tempBoards,nextNumber + 1);

    }
}
