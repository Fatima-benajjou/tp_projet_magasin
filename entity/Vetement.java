package org.example.tp_projet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data

public class Vetement extends Article{
    private CategorieVetement Categorie;
    private String taille;

}
