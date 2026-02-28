package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class BowlingShoes extends BowlingSupply {
    private int shoeSize;
    private String color;
    private String sole; // left or right-handed sole, ei. if you're right-handed your left shoe will be slider than right one
    private String mainMaterial; // synthetic leather, mesh, canvas, full leather

    public BowlingShoes() {}

    public BowlingShoes(String productId, String name, double price, String brand, boolean maintenanceRequired, String skillLevel, int shoeSize, String color, String sole, String mainMaterial) {
        super(productId, name, price, brand, maintenanceRequired, skillLevel);
        this.shoeSize = shoeSize;
        this.color = color;
        this.sole = sole;
        this.mainMaterial = mainMaterial;
    }

    public int getShoeSize() {
        return shoeSize;
    }
    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSole() {
        return sole;
    }
    public void setSole(String sole) {
        this.sole = sole;
    }
    public String getMainMaterial() {
        return mainMaterial;
    }
    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.println("Enter Shoe Size: ");
        this.shoeSize = getInput(input, 1);
        System.out.println("Enter Shoe Color: ");
        this.color = getInput(input, "no color");
        System.out.println("Right-handed or left-handed shoe?: ");
        this.sole = getInput(input, "Right-handed");
        System.out.println("Enter Main Material: ");
        this.mainMaterial = getInput(input, "canvas");
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Enter Shoe Size: ");
        this.shoeSize = getInput(input, getShoeSize());
        System.out.println("Enter Shoe Color: ");
        this.color = getInput(input, getColor());
        System.out.println("Right-handed or left-handed shoe?: ");
        this.sole = getInput(input, getSole());
        System.out.println("Enter Main Material: ");
        this.mainMaterial = getInput(input, getMainMaterial());
    }

    @Override
    public String toString() {
        return "BowlingShoes{" +
                "shoe size= " + shoeSize +
                ", color= " + color +
                ", sole= " + sole +
                ", main material= " + mainMaterial +
                ", " + super.toString() + "}";
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Bowling Shoes (Size " + getName() + ")...");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BowlingShoes that)) return false;
        if (!super.equals(o)) return false;
        return shoeSize == that.shoeSize && Objects.equals(color, that.color) && Objects.equals(sole, that.sole) && Objects.equals(mainMaterial, that.mainMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shoeSize, color, sole, mainMaterial);
    }
}