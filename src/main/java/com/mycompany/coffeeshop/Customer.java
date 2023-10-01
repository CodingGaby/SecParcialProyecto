package com.mycompany.coffeeshop;
import java.util.Arrays;
import java.util.Random;

public class Customer {
    Random random = new Random();

    //atributos
    private int idCustomer;
    private Order order;
    private String paymentMethod;

    //Constructor
    public Customer(){
        this.idCustomer = random.nextInt(100000) + 1;
        this.order = null;
        this.paymentMethod = "Efectivo";
    }

    //metodos
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(Order ord, String paymentMethod){
        ord.setPayed(true);
        this.paymentMethod = paymentMethod;
        ord.setPrice(0);
    }

    public Coffee[] chooseCoffee() {
        // Crear un array de objetos Coffee con diferentes tipos de café y precios
        Coffee[] coffeeList = {
                new Coffee("Café Latte", 37.5),
                new Coffee("Café Americano", 24.0),
                new Coffee("Cappuccino", 49.9),
                new Coffee("Mocha", 43.5),
                new Coffee("Espresso", 28.5)
        };

        // Número de cafés aleatorios que se seleccionarán (puedes ajustarlo)
        int numberOfCoffees = random.nextInt(3) + 1; // Selecciona de 1 a 3 cafés aleatorios

        // Array para almacenar los objetos Coffee seleccionados
        Coffee[] selectedCoffees = new Coffee[numberOfCoffees];

        // Seleccionar cafés aleatorios y agregarlos al array
        for (int i = 0; i < numberOfCoffees; i++) {
            int randomIndex = random.nextInt(coffeeList.length);
            selectedCoffees[i] = coffeeList[randomIndex];
        }

        return selectedCoffees;
    }

    public void askCoffee(){
        Order ord = new Order(chooseCoffee(), this.getIdCustomer());

        this.setOrder(ord);
        System.out.println("Quiero ordenar:");

        for (Coffee coffee : order.getCoffees()) {
            System.out.println("-" + coffee.getName());
        }
    }
}
