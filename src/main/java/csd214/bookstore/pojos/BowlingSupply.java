package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public abstract class BowlingSupply extends Product {
    private String brand;
    private boolean maintenanceRequired;
    private String skillLevel; // beginner, intermediate, advanced

    public BowlingSupply() {}

    public BowlingSupply(String productId, String name, double price, String brand, boolean maintenanceRequired, String skillLevel) {
        super(productId, "BowlingSupply", price);
        this.brand = brand;
        this.maintenanceRequired = maintenanceRequired;
        this.skillLevel = skillLevel;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public boolean isMaintenanceRequired() {
        return maintenanceRequired;
    }
    public void setMaintenanceRequired(boolean maintenanceRequired) {
        this.maintenanceRequired = maintenanceRequired;
    }
    public String getSkillLevel() {
        return skillLevel;
    }
    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.println("Enter Brand: ");
        this.brand = getInput(input, "no brand");
        System.out.println("Is maintenance required? (True/False): ");
        this.maintenanceRequired = getInput(input, true);
        System.out.println("Enter skill level required: ");
        this.skillLevel = getInput(input, "Beginner");
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Enter Brand: ");
        this.brand = getInput(input, getBrand());
        System.out.println("Is maintenance required? (True/False): ");
        this.maintenanceRequired = getInput(input, isMaintenanceRequired());
        System.out.println("Enter skill level required: ");
        this.skillLevel = getInput(input, getSkillLevel());
    }

    @Override
    public String toString() {
        return "BowlingSupply{" +
                "brand= " + brand +
                ", is maintenance required= " + maintenanceRequired +
                ", skill level= " + skillLevel +
                "}, " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BowlingSupply that)) return false;
        return maintenanceRequired == that.maintenanceRequired && Objects.equals(brand, that.brand) && Objects.equals(skillLevel, that.skillLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, maintenanceRequired, skillLevel);
    }
}