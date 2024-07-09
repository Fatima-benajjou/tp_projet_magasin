package org.example.tp_projet.Service;

import org.example.tp_projet.entity.*;
import org.example.tp_projet.repository.ElectroniqueRepo;
import org.example.tp_projet.repository.LigneVenteRepo;
import org.example.tp_projet.repository.VenteRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VenteService {
    Scanner sc = new Scanner(System.in);
    private VenteRepo venteRepo = new VenteRepo();
    private LigneVenteRepo ligneVenteRepo = new LigneVenteRepo();
    private ClientService clientService = new ClientService();
    private NourritureService nourritureService = new NourritureService();
    private ElectroniqueService electroniqueService = new ElectroniqueService();
    private VetementService vetementService = new VetementService();


    public void createVente() {
        System.out.println("\nEnregistrement d'une vente\n");
        List<LigneVente> ligneVentes = new ArrayList<>();
        Vente vente = new Vente();

        System.out.println("Choix client");
        clientService.findAll();
        Client clientVente = clientService.findById();

        do {
            System.out.println("Selectionnez l'article ? ");
            System.out.println("1. Oui");
            System.out.println("0. Non (quitter)");
            int entreeUtilisateur = sc.nextInt();
            sc.nextLine();

            if(entreeUtilisateur == 0)
                break;

            nourritureService.findAll();
            Nourriture nourriture = nourritureService.findById();

            //Si article déjà sélectionnée alors dire que ce n'est pas possible

            System.out.println("Quel Quantité");
            int quantiteArticle = sc.nextInt();
            sc.nextLine();

            LigneVente ligneVente = LigneVente.builder()
                    .article(nourriture)
                    .vente(vente)
                    .quantite(quantiteArticle)
                    .build();

            ligneVentes.add(ligneVente);
        }while (true);

        vente.setDateVente(LocalDate.now());
        vente.setClient(clientVente);
        vente.setLigneVentes(ligneVentes);

        vente.setTypeVente(TypeVente.FINALISE);

        venteRepo.save(vente);

    }}

