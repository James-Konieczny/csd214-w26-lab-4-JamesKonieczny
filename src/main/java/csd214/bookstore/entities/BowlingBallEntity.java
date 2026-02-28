package csd214.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("BOWLING_BALL")
public class BowlingBallEntity extends BowlingSupplyEntity {
    @Column(name = "weight")
    private int weight; // 6-16lbs
    @Column(name = "color")
    private String color;
    @Column(name = "coverstock")
    private String coverstock; // plastic, urethane, reactive resin, hybrid
    @Column(name = "core")
    private String core; // symmetrical, asymmetrical

    public BowlingBallEntity() { super(); }

    public BowlingBallEntity(String name, double price, String brand, boolean maintenanceRequired, String skillLevel, int weight, String color, String coverstock, String core) {
        super(name, price, brand, maintenanceRequired, skillLevel);
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
    public String toString() {
        return "BowlingBallEntity{" +
                "weight (lbs)= " + weight +
                ", color= " + color +
                ", coverstock= " + coverstock +
                ", core= " + core +
                ", " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingBallEntity that)) return false;
        if (!super.equals(o)) return false;
        return weight == that.weight && Objects.equals(color, that.color) && Objects.equals(coverstock, that.coverstock) && Objects.equals(core, that.core);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, color, coverstock, core);
    }
}