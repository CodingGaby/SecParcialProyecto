package com.mycompany.coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShopGame {
    public static void main(String[] args) {
        Scanner inpc = new Scanner(System.in);
        List<Integer> opcCC = new ArrayList<>();
        int pointsAdded = 0;
        int pointsSubtracted = 0;
        int level = 1;
        char opcC2;
        boolean gameout = false;

        Coffee[] coffeeList = {
                new Coffee("Café Latte", 37.5),
                new Coffee("Café Americano", 24.0),
                new Coffee("Cappuccino", 49.9),
                new Coffee("Mocha", 43.5),
                new Coffee("Espresso", 28.5)
        };

        while (!gameout) {
            Customer cus = new Customer();
            System.out.println("\u001B[32mUn nuevo cliente está entrando!\u001B[0m\n");

            System.out.println("\u001B[36mHola!, ¿Qué tal?\u001B[0m");
            cus.askCoffee();

            System.out.println("\nElige el café que ordenó el cliente \u001B[36m(1-5)\u001B[0m:");

            // Display the coffee options
            for (int i = 0; i < coffeeList.length; i++) {
                System.out.println("\u001B[33m" + (i + 1) + ". \u001B[0m" + coffeeList[i].getName());
            }
            System.out.print("\n");

            // Initialize isCorrectChoice based on the current customer's order
            boolean[] isCorrectChoice = new boolean[coffeeList.length];
            Coffee[] currentOrder = cus.getOrder().getCoffees();
            for (Coffee coffee : currentOrder) {
                for (int j = 0; j < coffeeList.length; j++) {
                    if (coffee.getName().equalsIgnoreCase(coffeeList[j].getName())) {
                        isCorrectChoice[j] = true;
                    }
                }
            }

            // Collect the customer's choices
            int numOptions = currentOrder.length;
            do {
                for (int i = 0; i < numOptions; i++) {
                    System.out.print("\u001B[36mOpción " + (i + 1) + ": \u001B[0m");
                    int choice = inpc.nextInt();
                    if (choice < 1 || choice > coffeeList.length) {
                        System.out.println("\u001B[31mOpción no válida. Elige una opción válida.\u001B[0m");
                        i--;
                    } else {
                        opcCC.add(choice);
                    }
                }

                System.out.println("\nConfirmar la orden: (\u001B[32mS/N\u001B[0m):");
                for (int choice : opcCC) {
                    System.out.println("\u001B[33m" + coffeeList[choice - 1].getName() + "\u001B[0m");
                }

                opcC2 = inpc.next().charAt(0);

                if (opcC2 == 'n' || opcC2 == 'N') {
                    opcCC.clear();
                }
            } while (opcC2 != 's' && opcC2 != 'S');

            // Check if the choices were correct and update points accordingly
            boolean choicesCorrect = true;

            for (int choice : opcCC) {
                if (isCorrectChoice[choice - 1]) {
                    pointsAdded += 2;
                } else {
                    pointsSubtracted += 1;
                    choicesCorrect = false;
                    System.out.println("\u001B[31m¡Yo no quería un " + coffeeList[choice - 1].getName() + "!\u001B[0m");
                }
            }

            if (choicesCorrect) {
                System.out.println("\u001B[32m¡Es justo lo que ordené!\u001B[0m");
                System.out.println("\u001B[36mPuntos sumados: " + pointsAdded + "\u001B[0m");
            } else {
                System.out.println("\u001B[31mPuntos restados: " + pointsSubtracted + "\u001B[0m");
            }

            int totalPoints = pointsAdded - pointsSubtracted;
            System.out.println("\u001B[36mPuntaje total: " + totalPoints + "\u001B[0m");

            if (totalPoints % 10 == 0) {
                level++;
                System.out.println("\u001B[36m¡Has subido de nivel! Nivel actual: " + level + "\u001B[0m");
            }

            opcCC.clear();
            inpc.nextLine();
            System.out.println("\n¿Deseas atender a otro cliente? (\u001B[32mS/N\u001B[0m): ");
            String response = inpc.nextLine();

            if (!response.equalsIgnoreCase("S")) {
                gameout = true;
            }
        }
    }
}
