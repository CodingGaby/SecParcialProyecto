package com.mycompany;

import java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tamaño del tablero
        int rows = 6;
        int cols = 7;

        // Crear el tablero
        char[][] board = new char[rows][cols];

        // Inicializar el tablero
        initializeBoard(board);

        // Variables para rastrear el jugador actual
        char currentPlayer = 'X';
        boolean gameWon = false;

        // Juego principal
        while (!gameWon) {
            // Imprimir el tablero
            printBoard(board);

            // Solicitar al jugador actual que haga un movimiento
            System.out.println("\u001B[36mJugador " + currentPlayer + ", es tu turno. Ingresa la columna (0-" + (cols - 1) + "): \u001B[0m");
            int column = scanner.nextInt();

            // Validar la entrada del jugador y realizar el movimiento
            if (isValidMove(board, column)) {
                int row = dropPiece(board, column, currentPlayer);
                gameWon = checkWin(board, row, column, currentPlayer);
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("\u001B[31mMovimiento inválido. Inténtalo de nuevo.\u001B[0m");
            }
        }

        // Imprimir el tablero final
        printBoard(board);

        // Anunciar al ganador
        System.out.println("\u001B[32m¡Jugador " + currentPlayer + " ha ganado!\u001B[0m");
    }

    // Inicializa el tablero con espacios en blanco
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Imprime el tablero actual
    public static void printBoard(char[][] board) {
        System.out.println("  0   1   2   3   4   5   6");
        for (char[] chars : board) {
            System.out.print("| ");
            for (int j = 0; j < board[0].length; j++) {
                char piece = chars[j];
                String color = (piece == 'X') ? "\u001B[31m" : (piece == 'O') ? "\u001B[33m" : "\u001B[37m";
                System.out.print(color + piece + " \u001B[0m| ");
            }
            System.out.println();
        }
    }

    // Verifica si un movimiento es válido
    public static boolean isValidMove(char[][] board, int column) {
        return column >= 0 && column < board[0].length && board[0][column] == ' ';
    }

    // Realiza un movimiento en el tablero y devuelve la fila donde se colocó la ficha
    public static int dropPiece(char[][] board, int column, char player) {
        int row = board.length - 1;
        while (row >= 0 && board[row][column] != ' ') {
            row--;
        }
        if (row >= 0) {
            board[row][column] = player;
        }
        return row;
    }

    // Verifica si el jugador actual ha ganado
    public static boolean checkWin(char[][] board, int row, int col, char player) {
        // Verificar fila
        for (int i = 0; i < board[0].length - 3; i++) {
            if (board[row][i] == player &&
                    board[row][i + 1] == player &&
                    board[row][i + 2] == player &&
                    board[row][i + 3] == player) {
                return true;
            }
        }

        // Verificar columna
        for (int i = 0; i < board.length - 3; i++) {
            if (board[i][col] == player &&
                    board[i + 1][col] == player &&
                    board[i + 2][col] == player &&
                    board[i + 3][col] == player) {
                return true;
            }
        }

        // Verificar diagonal principal (de izquierda a derecha)
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == player &&
                        board[i + 1][j + 1] == player &&
                        board[i + 2][j + 2] == player &&
                        board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }

        // Verificar diagonal secundaria (de derecha a izquierda)
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (board[i][j] == player &&
                        board[i + 1][j - 1] == player &&
                        board[i + 2][j - 2] == player &&
                        board[i + 3][j - 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }
}
