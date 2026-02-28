package csd214.bookstore.jpa;

import csd214.bookstore.entities.BowlingBallEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class JpaBowlingBallApp {
    public static void main(String[] args) {
        // 1. Initialize the Engine
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstore-pu");
        EntityManager em = emf.createEntityManager();

        try {
            // --- CREATE ---
            System.out.println("\n[Step 1] Creating a new Bowling Ball...");
            em.getTransaction().begin();
            BowlingBallEntity myBall = new BowlingBallEntity("Magnitude 035", 233.05, "Brunswick", true, "intermediate", 15, "Blue", "Relativity Flip Solid", "Low Diff Symmetric");
            em.persist(myBall); // Tells Hibernate to save the object
            em.getTransaction().commit();
            System.out.println("Bowling Ball saved with Database ID: " + myBall.getId());

            // --- READ (List All) ---
            listBowlingBall(em, "[Step 2] Current Inventory:");

            // --- UPDATE (Find & Edit) ---
            System.out.println("\n[Step 3] Editing Bowling Ball Price...");
            em.getTransaction().begin();

            // We use the ID to find the specific record
            BowlingBallEntity ballToEdit = em.find(BowlingBallEntity.class, myBall.getId());
            if (ballToEdit != null) {
                ballToEdit.setPrice(499.99); // Change the Java field
                // Note: We don't call "update". Hibernate detects the change
                // automatically when we commit (Dirty Checking).
            }

            em.getTransaction().commit();
            listBowlingBall(em, "[Step 4] After Price Update:");

            // --- DELETE ---
            System.out.println("\n[Step 5] Deleting the Bowling Ball...");
            em.getTransaction().begin();

            BowlingBallEntity ballToDelete = em.find(BowlingBallEntity.class, myBall.getId());
            if (ballToDelete != null) {
                em.remove(ballToDelete); // Tells Hibernate to delete the row
            }

            em.getTransaction().commit();
            listBowlingBall(em, "[Step 6] Final Inventory (should be empty):");

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
    private static void listBowlingBall(EntityManager em, String header) {
        System.out.println("\n" + header);
        List<BowlingBallEntity> balls = em.createQuery("SELECT t FROM BowlingBallEntity t", BowlingBallEntity.class).getResultList();
        if (balls.isEmpty()) {
            System.out.println("No bowling balls found in database.");
        } else {
            balls.forEach(t -> System.out.println(" > " + t));
        }
    }
}