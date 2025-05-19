package com.pharmacy.model;

//this class represent an order item in the pharmacy system
public class OrderItem {
    private Medication medication;
    private int quantity;

    public OrderItem(Medication medication, int quantity) {
        this.medication = medication;
        this.quantity = quantity;
    }
//setters and getters
    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Calculate the total cost of this order item
     * @return Total cost
     */
    public double calculateCost() {
        return medication.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "medication=" + medication.getName() +
                ", quantity=" + quantity +
                '}';
    }
}

