package csd214.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
public class BowlingSupplyEntity extends ProductEntity {
    @Column(name = "brand")
    private String brand;
    @Column(name = "maintenance_required")
    private boolean maintenanceRequired;
    @Column(name = "skill_level")
    private String skillLevel; // beginner, intermediate, advanced

    public BowlingSupplyEntity() { super(); }

    public BowlingSupplyEntity(String name, double price, String brand, boolean maintenanceRequired, String skillLevel) {
        this.setName(name);
        this.setPrice(price);
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
    public String toString() {
        return "BowlingSupplyEntity{" +
                "brand= " + brand +
                ", is maintenance required= " + maintenanceRequired +
                ", skill level= " + skillLevel +
                "}, " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingSupplyEntity that)) return false;
        if (getId() != null && Objects.equals(getId(), that.getId())) return true;
        return maintenanceRequired == that.maintenanceRequired && Objects.equals(brand, that.brand) && Objects.equals(skillLevel, that.skillLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, maintenanceRequired, skillLevel);
    }

}