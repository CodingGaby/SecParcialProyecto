package com.mycompany;

import com.mycompany.coffeeshop.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Sort sort = new Sort();

        System.out.println("\u001B[36mBienvenidx!\u001B[0m"); // Cyan color for the welcome message

        while (true) {
            System.out.println("\nElige qué programa quieres usar ^^\n\t\033[1;33ma. Ordenar arreglos\u001B[0m\n\t\033[1;33mb. Juegos\u001B[0m\n\t\033[1;31mq. Salir\u001B[0m"); // Yellow for options a and b, Red for q
            char opc = inp.next().charAt(0);

            switch (opc) {
                case 'a' -> {
                    int[] cusArr = new int[5];

                    System.out.println("\u001B[32mCreemos tu arreglo!\u001B[0m"); // Green for creating an array

                    for (int i = 0; i < cusArr.length; i++) {
                        System.out.print("\nDame el elemento \u001B[34m" + (i + 1) + "\u001B[0m:");
                        cusArr[i] = inp.nextInt();
                    }
                    System.out.println("\u001B[34mArray desordenado:");
                    sort.printArray(cusArr);

                    System.out.println("\n¿Qué algoritmo de ordenamiento deseas usar?\n\t\033[1;34ma. Bubble b. Selection c. Insertion\u001B[0m"); // Blue for sorting options
                    char opc2 = inp.next().charAt(0);


                    switch (opc2) {
                        case 'a' -> sort.bubble(cusArr);
                        case 'b' -> sort.selection(cusArr);
                        case 'c' -> sort.insertion(cusArr);
                        default -> System.out.println("\u001B[31mOpción inválida, ingresa una opción válida\u001B[0m"); // Red for invalid option
                    }
                    System.out.println("\u001B[34mArray ordenado:");
                    sort.printArray(cusArr);
                }
                case 'b' -> {
                    System.out.println("\u001B[32mVamos a jugar!\u001B[0m"); // Green for starting a game
                    System.out.println("\n¿Qué deseas jugar?\n\t\033[1;34ma. Conecta 4 b. Cafetería\u001B[0m"); // Blue for game options
                    char opc2 = inp.next().charAt(0);

                    switch (opc2) {
                        case 'a' -> Connect4Game.main(new String[0]);
                        case 'b' -> CoffeeShopGame.main(new String[0]);
                        default -> System.out.println("\u001B[31mOpción inválida, ingresa una opción válida\u001B[0m"); // Red for invalid option
                    }
                }
                case 'q' -> {
                    System.out.println("\u001B[31mSaliendo del programa...\u001B[0m"); // Red for exiting
                    System.exit(0);
                }
                default -> System.out.println("\u001B[31mOpción inválida, ingresa una opción válida\u001B[0m"); // Red for invalid option
            }
        }
    }
}
