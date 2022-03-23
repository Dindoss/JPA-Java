package fr.sdv.jpa;

import fr.sdv.jpa.entity.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class App {

    public static void main(String[] args){

        // EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdv-demo-jpa");
        EntityManager em = emf.createEntityManager();

        // Récupérer une instance
        Livre livre = em.find(Livre.class,2);
        if (livre != null){
            System.out.println("ID du livre : " + livre.getId());
            System.out.println("Nom du livre : " + livre.getTitre());
            System.out.println("Nom de l'auteur : " + livre.getAuteur());
        }

        // Création objet
        em.getTransaction().begin();

        Livre unLivre = new Livre("Toto", "Patrick");
        System.out.println("Création d'un livre");
        em.persist(unLivre);


        // Modification objet
        System.out.println("Modification de l'existant");
        Livre h = em.find(Livre.class, 5);
        h.setTitre("Du plaisir, incroyable");
        em.persist(h);

        // Récupérer une instance
        TypedQuery<Livre> query = em.createQuery("SELECT livre from Livre livre WHERE livre.titre = 'Germinal'", Livre.class);
        Livre titre = query.getResultList().get(0);

        TypedQuery<Livre> query2 = em.createQuery("SELECT livre from Livre livre WHERE livre.auteur = 'Jean-Pierre Coffe'", Livre.class);
        Livre auteur = query2.getResultList().get(0);

        //Supprimer objet
        System.out.println("Suppression de l'existant");
        em.remove(unLivre);

        ArrayList<String> auteurs_L = new ArrayList<>();
        ArrayList<String> titres_L = new ArrayList<>();
        for (int i=1; i < 6; i++){
            Livre all = em.find(Livre.class, i);
            auteurs_L.add(all.getAuteur());
            titres_L.add(all.getTitre());
        }
        System.out.println("##### LISTE D'AUTEURS #####");
        System.out.println(auteurs_L.toString());
        System.out.println("##### LISTE TITRES #####");
        System.out.println(titres_L);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
