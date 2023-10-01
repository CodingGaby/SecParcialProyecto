package com.mycompany.coffeeshop;

public class Order {
    private Coffee[] coffees;
    private double price;
    private int idCustomer;
    private boolean isPayed;

    public Order(Coffee[] coffees, int id) {
        this.coffees = coffees;
        this.price = calculateTotalPrice();
        this.idCustomer = id; // El ID del cliente se establecerá posteriormente
        this.isPayed = false;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public Coffee[] getCoffees() {
        return coffees;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Coffee coffee : coffees) {
            totalPrice += coffee.getPrice();
        }
        return totalPrice;
    }
}
