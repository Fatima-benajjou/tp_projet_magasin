package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Article {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float prix;
    private int quantite;
    private String dateRestock;

    @OneToMany (mappedBy = "article")
    private List<LigneVente> ligneVentes;

    public void setQuantite(int quantite) {
        this.quantite = quantite;
        this.dateRestock=dateRestock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", dateRestock='" + dateRestock + '\'' +
                '}';
    }
}


