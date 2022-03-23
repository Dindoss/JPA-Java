package fr.sdv.jpa.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="EMPRUNT")
public class Emprunt implements Serializable {

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    public Emprunt() {
    }

    public Emprunt(Date date_debut, Date date_fin, Integer delai) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.delai = delai;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // COLUMN
    @Column(name = "DATE_DEBUT", nullable = false)
    private Date date_debut;

    @Column(name = "DATE_FIN", nullable = true)
    private Date date_fin;

    @Column(name = "DELAI", nullable = true, length = 10)
    private Integer delai;


    //GETTER
    public int getId() {
        return id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public Integer getDelai() {
        return delai;
    }


    //SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }
}
