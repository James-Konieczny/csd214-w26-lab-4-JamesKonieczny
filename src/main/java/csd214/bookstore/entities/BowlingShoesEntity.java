package csd214.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("BOWLING_SHOES")
public class BowlingShoesEntity extends BowlingSupplyEntity {
    @Column(name = "shoe_size")
    private int shoeSize;
    @Column(name = "color")
    private String color;
    @Column(name = "sole")
    private String sole; // left or right-handed sole, ei. if you're right-handed your left shoe will be slider than right one
    @Column(name = "main_material")
    private String mainMaterial; // synthetic leather, mesh, canvas, full leather

    public BowlingShoesEntity() { super(); }

    public BowlingShoesEntity(String name, double price, String brand, boolean maintenanceRequired, String skillLevel, int shoeSize, String color, String sole, String mainMaterial) {
        super(name, price, brand, maintenanceRequired, skillLevel);
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
    public String toString() {
        return "BowlingShoesEntity{" +
                "shoe size= " + shoeSize +
                ", color= " + color +
                ", sole= " + sole +
                ", main material= " + mainMaterial +
                ", " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingShoesEntity that)) return false;
        if (!super.equals(o)) return false;
        return shoeSize == that.shoeSize && Objects.equals(color, that.color) && Objects.equals(sole, that.sole) && Objects.equals(mainMaterial, that.mainMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shoeSize, color, sole, mainMaterial);
    }
}