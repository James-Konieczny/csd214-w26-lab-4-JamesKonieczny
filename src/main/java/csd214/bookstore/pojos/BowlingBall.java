package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class BowlingBall extends BowlingSupply {
    private int weight; // 6-16lbs
    private String color;
    private String coverstock; // plastic, urethane, reactive resin, hybrid
    private String core; // symmetrical, asymmetrical

    public BowlingBall() {}

    public BowlingBall(String productId, String name, double price, String brand, boolean maintenanceRequired, String skillLevel, int weight, String color, String coverstock, String core) {
        super(productId, name, price, brand, maintenanceRequired, skillLevel);
        this.weight = weight;
        this.color = color;
        this.coverstock = coverstock;
        this.core = core;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getCoverstock() {
        return coverstock;
    }
    public void setCoverstock(String coverstock) {
        this.coverstock = coverstock;
    }
    public String getCore() {
        return core;
    }
    public void setCore(String core) {
        this.core = core;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.println("Enter Ball Weight (6-16lbs): ");
        this.weight = getInput(input, 6);
        System.out.println("Enter Ball Color: ");
        this.color = getInput(input, "no color");
        System.out.println("Enter Ball Coverstock: ");
        this.coverstock = getInput(input, "plastic");
        System.out.println("Enter Ball Core: ");
        this.core = getInput(input, "symmetrical");
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Enter Ball Weight (6-16lbs): ");
        this.weight = getInput(input, getWeight());
        System.out.println("Enter Ball Color: ");
        this.color = getInput(input, getColor());
        System.out.println("Enter Ball Coverstock: ");
        this.coverstock = getInput(input, getCoverstock());
        System.out.println("Enter Ball Core: ");
        this.core = getInput(input, getCore());
    }

    @Override
    public String toString() {
        return "BowlingBall{" +
                "weight (lbs)= " + weight +
                ", color= " + color +
                ", coverstock= " + coverstock +
                ", core= " + core +
                ", " + super.toString() + "}";
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + weight + "lbs Bowling Ball (" + getName() + ")...");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BowlingBall that)) return false;
        if (!super.equals(o)) return false;
        return weight == that.weight && Objects.equals(color, that.color) && Objects.equals(coverstock, that.coverstock) && Objects.equals(core, that.core);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, color, coverstock, core);
    }
}