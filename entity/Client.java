package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder

public class Client {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     @Column (name = "id_habitant")
    private int id;
    private String nom;
    private String prenom;



}
