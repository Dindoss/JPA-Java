package fr.sdv.jpa;

import fr.sdv.jpa.entity.Client;
import fr.sdv.jpa.entity.Emprunt;
import fr.sdv.jpa.entity.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestBibliotheque {
    public static void main(String[] args) {

        // EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdv-demo-jpa");
        EntityManager em = emf.createEntityManager();

        // Récupérer une instance
        TypedQuery<Emprunt> query = em.createQuery("SELECT emprunt from Emprunt emprunt WHERE id.client = 1", Emprunt.class);
        Emprunt unEmprunt = query.getResultList().get(0);
        System.out.println(unEmprunt);

        TypedQuery<Emprunt> query2 = em.createQuery("SELECT client from Emprunt emprunt WHERE id = 1", Emprunt.class);
        Emprunt unClient = query2.getResultList().get(0);
        System.out.println(unClient);
    }
}
