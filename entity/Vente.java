package org.example.tp_projet.entity;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

public class Vente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Colum(name = "id_vente")
    private String dateVente
    private TypeVente typeVente;
    @ManyToOne
    @JoinColum(name = "id=Client")
    private Client client;

    @ManyToMany (cascade = CascadeType.PERSIST)

    @JoinTable(name = "vente_article",
            joinColumns = @JoinColumn(name = "id_vente"),
            inverseJoinColumns = @JoinColumn(name = "id_article"))
    List<Article> articles;

    public Vente (String name) {
        this.name = name;
        articles = new ArrayList<>();
    }
    @Override
}
