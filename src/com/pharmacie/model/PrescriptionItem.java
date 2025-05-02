package com.pharmacie.model;

public class PrescriptionItem {
    private Medication medication;
    private String dosage;
    private String frequency;
    private int durationInDays;
    private int quantity;

    public PrescriptionItem(Medication medication, String dosage, String frequency, int durationInDays) {
        this.medication = medication;
        this.dosage = dosage;
        this.frequency = frequency;
        this.durationInDays = durationInDays;
        // Calculate quantity based on duration and frequency
        this.quantity = calculateQuantity();
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
        // Recalculate quantity when frequency changes
        this.quantity = calculateQuantity();
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
        // Recalculate quantity when duration changes
        this.quantity = calculateQuantity();
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculate the total cost of this prescription item
     * @return Total cost
     */
    public double calculateCost() {
        return medication.getPrice() * quantity;
    }

    /**
     * Parse frequency and calculate total quantity needed
     * Simplified implementation - in real world, would need more complex parsing
     * @return Calculated quantity
     */
    private int calculateQuantity() {
        // Simple implementation - assumes frequency format like "2 times daily"
        try {
            String[] parts = frequency.split(" ");
            int timesPerDay = Integer.parseInt(parts[0]);
            return timesPerDay * durationInDays;
        } catch (Exception e) {
            // Default to once per day if parsing fails
            return durationInDays;
        }
    }

    @Override
    public String toString() {
        return "PrescriptionItem{" +
                "medication=" + medication.getName() +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", durationInDays=" + durationInDays +
                ", quantity=" + quantity +
                '}';
    }
}