package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class LigneVente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;

    @ManyToOne
    @JoinColumn(name= "id_vente")
    private Vente vente;


    @ManyToOne
    @JoinColumn(name= "id_article")
    private Article article;

    @Override
    public String toString() {
        return "LigneVente{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", vente=" + vente +
                ", article=" + article +
                ", Resultat =" + quantite * article.getPrix();

    }
}
