package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Vetement extends Article{
    private CategorieVetement Categorie;
    private String taille;

    @Override
    public String toString() {
        return "Vetement{" +
                "Categorie=" + Categorie +
                ", taille='" + taille + '\'' +
                "} " + super.toString();
    }
}
