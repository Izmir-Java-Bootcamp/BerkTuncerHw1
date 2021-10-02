package com.kodluyoruz;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the N: ");
        int n = scan.nextInt();


        String[][] board = new String[n][n];

        createBoard(board, n);
        printBoard(board);

    }

    public static void createBoard(String[][] board, int n){

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i % 2 == 1){
                    if (j % 2 == 1)
                        board[i][j] = "+";
                    else
                        board[i][j] = " ";
                }
                if(i % 2 == 0){
                    if (j % 2 == 1)
                        board[i][j] = " ";
                    else
                        board[i][j] = "+";
                }
                board[0][j] = "*";
                board[n-1][j] = "*";
            }
            board[i][0] = "*";
            board[i][n-1] = "*";
        }

    }

    public static void printBoard(String[][] board){

        for (String[] strings : board) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println("");
        }

    }
}
