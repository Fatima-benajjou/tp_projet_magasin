package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TypeVente typeVente;
    private LocalDate dateVente;

    @OneToMany (mappedBy= "vente", fetch = FetchType.EAGER)
    private List<LigneVente> ligneVentes;

    @ManyToOne
    @JoinColumn(name = "id_Client")
    private Client client;


    @Override
    public String toString() {
        return "Vente{" +
                "id=" + id +
                ", typeVente=" + typeVente +
                ", dateVente=" + dateVente +
                ", ligneVentes=" + ligneVentes +
                ", client=" + client +
                '}';
    }
}

