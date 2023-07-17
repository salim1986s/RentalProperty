package om.gov.taxoman;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Salim.jpa");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();




        em.getTransaction().commit();
        em.close();
        emf.close();




    }
}