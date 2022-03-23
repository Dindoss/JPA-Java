package fr.sdv.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="LIVRE")
public class Livre implements Serializable {

    public Livre() {
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Column(name = "TITRE", nullable = false, length = 255)
    private String titre;

    public String getTitre(){
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Column(name = "AUTEUR", nullable = false, length = 50)
    private String auteur;

    public String getAuteur(){
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
