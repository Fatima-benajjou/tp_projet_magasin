package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Article {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private float prix;
    private int quantite;
    private String dateRestock;

}
