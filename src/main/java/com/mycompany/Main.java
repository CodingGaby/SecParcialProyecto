package com.mycompany;

import com.mycompany.coffeeshop.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Sort sort = new Sort();

        System.out.println("Bienvenidx!");

        while (true){
            System.out.println("\nElige que programa quieres usar ^^\n\t\ta.Ordenar arreglos \n\t\tb.Juegos \n\t\t\tq.Salir");
            int opc = inp.next().charAt(0);

            switch (opc){
                case 'a' -> {
                    int[] cusArr = new int[5];

                    System.out.println("Creemos tu arreglo!");

                    for (int i = 0; i < cusArr.length; i++){
                        System.out.print("\nDame el elemento "+(i+1)+":");
                        cusArr[i] = inp.nextInt();
                    }

                    System.out.println("\n¿Que algoritmo de ordenamiento deseas usar?\n\t\ta.Bubble b.Selection c.Insertion");
                    int opc2 = inp.next().charAt(0);

                    switch (opc2){
                        case 'a' -> sort.bubble(cusArr);
                        case 'b' -> sort.selection(cusArr);
                        case 'c' -> sort.insertion(cusArr);
                        default -> System.out.println("Opcion invalida, ingresa una opción valida");
                    }

                    sort.printArray(cusArr);
                }
                case 'b' -> {
                    System.out.println("Vamos a jugar!");
                    System.out.println("\n¿Qué deseas jugar?\n\t\ta.Conecta 4 b.Cafeteria");
                    int opc2 = inp.next().charAt(0);

                    switch (opc2){
                        case 'a' -> Connect4Game.main(new String[0]);
                        case 'b' -> CoffeeShopGame.main(new String[0]);
                        default -> System.out.println("Opcion invalida, ingresa una opción valida");
                    }
                }
                case 'q' ->{
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Opcion invalida, ingresa una opcion valida;c");
            }
        }
    }
}