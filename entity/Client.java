package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Client {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Vente> listeVentes;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", listeVentes=" + listeVentes +
                '}';
    }
}
