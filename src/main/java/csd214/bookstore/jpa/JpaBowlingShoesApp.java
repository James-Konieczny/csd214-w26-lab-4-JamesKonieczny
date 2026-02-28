package csd214.bookstore.jpa;

import csd214.bookstore.entities.BowlingBallEntity;
import csd214.bookstore.entities.BowlingShoesEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class JpaBowlingShoesApp {
    public static void main(String[] args) {
        // 1. Initialize the Engine
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstore-pu");
        EntityManager em = emf.createEntityManager();

        try {
            // --- CREATE ---
            System.out.println("\n[Step 1] Creating a pair of new Bowling Shoes...");
            em.getTransaction().begin();
            BowlingShoesEntity myShoes = new BowlingShoesEntity("BowlingSupply", 63.25, "Dexter", true, "beginner", 10, "Red", "right-handed", "synthetic leather");
            em.persist(myShoes); // Tells Hibernate to save the object
            em.getTransaction().commit();
            System.out.println("Bowling Shoes saved with Database ID: " + myShoes.getId());

            // --- READ (List All) ---
            listBowlingShoes(em, "[Step 2] Current Inventory:");

            // --- UPDATE (Find & Edit) ---
            System.out.println("\n[Step 3] Editing Bowling Shoes Price...");
            em.getTransaction().begin();

            // We use the ID to find the specific record
            BowlingShoesEntity shoesToEdit = em.find(BowlingShoesEntity.class, myShoes.getId());
            if (shoesToEdit != null) {
                shoesToEdit.setPrice(69.99); // Change the Java field
                // Note: We don't call "update". Hibernate detects the change
                // automatically when we commit (Dirty Checking).
            }

            em.getTransaction().commit();
            listBowlingShoes(em, "[Step 4] After Price Update:");

            // --- DELETE ---
            System.out.println("\n[Step 5] Deleting the Bowling Shoes...");
            em.getTransaction().begin();

            BowlingShoesEntity shoesToDelete = em.find(BowlingShoesEntity.class, myShoes.getId());
            if (shoesToDelete != null) {
                em.remove(shoesToDelete); // Tells Hibernate to delete the row
            }

            em.getTransaction().commit();
            listBowlingShoes(em, "[Step 6] Final Inventory (should be empty):");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Always close your resources
            em.close();
            emf.close();
        }
    }

    /**
     * Helper method to run a JPQL query and print results
     */
    private static void listBowlingShoes(EntityManager em, String header) {
        System.out.println("\n" + header);
        List<BowlingShoesEntity> shoes = em.createQuery("SELECT t FROM BowlingShoesEntity t", BowlingShoesEntity.class).getResultList();
        if (shoes.isEmpty()) {
            System.out.println("No bowling shoes found in database.");
        } else {
            shoes.forEach(t -> System.out.println(" > " + t));
        }
    }
}