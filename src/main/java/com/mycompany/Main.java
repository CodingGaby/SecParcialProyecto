package com.mycompany;

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
                    System.out.println("La opcion es A");
                }
                case 'b' -> {
                    System.out.println("La opcion es B");
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