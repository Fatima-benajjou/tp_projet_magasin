package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.entity.Electronique;
import org.example.tp_projet.repository.ElectroniqueRepo;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Scanner;

public class ElectroniqueService {


     ElectroniqueRepo electroniqueRepo = new ElectroniqueRepo ();

    public Electronique create(String description, float prix, int quantite, String dateRestock, String batterieDuration) {
        Electronique electronique = Electronique.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .batterieDuration(batterieDuration)
                .build();
        return electroniqueRepo.save(electronique);
    }

    public Electronique update() {
        System.out.println("Veuillez saisir l'Id que vous souhaiter modifier");
        Electronique electronique = electroniqueRepo.getById(Electronique.class, sc.nextInt());

        if (electronique != null) {
            System.out.println("Entrez une nouvelle description");
            electronique.setDescription(sc.nextLine());
            System.out.println("Entrez nouveau prix");
            electronique.setPrix(sc.nextInt());
            System.out.println("Entrez une nouvelle quantité");
            electronique.setQuantite(sc.nextInt());
            System.out.println("Entrez nouvelle date de reassort");
            electronique.setDateRestock(sc.nextLine());
            System.out.println("Entrez la durée de baterie");
            electronique.setBatterieDuration(sc.nextLine());

            electroniqueRepo.save(electronique);
            return electronique;
        }
        throw new EntityNotFoundException("Article non trouvé");
    }


    public boolean delete() {
        System.out.println("Saisir l'Id que vous souhiatez supprimer");
        Electronique electronique = electroniqueRepo.getById(Electronique.class, sc.nextInt());
        if (electronique != null) {
            electroniqueRepo.delete(electronique);
            return true;
        }
        throw new EntityNotFoundException("Article non trouvé");
    }

    public Electronique findById() {
        System.out.println("Saisir l'ID que vous rechercher");
        Electronique electronique = electroniqueRepo.getById(Electronique.class, sc.nextInt());
        if(electronique != null) {
        return electronique;
    }
    throw new

    EntityNotFoundException("Aucun article trouvé pour cet ID");
}

    public void findAll(){
        List<Electronique> electroniques = getAll();
        if(electroniques == null)
            return;
        System.out.println(electroniques);
    }


    public List<Electronique> getAll() {
        return electroniqueRepo.getAll();
    }

    private Scanner sc = new Scanner(System.in);

    public void createElectronique() {
        System.out.println("-----Creation Article Electronique---");
        System.out.println("Description Article :");
        String description = sc.nextLine();
        System.out.println("Prix :");
        Float prix = sc.nextFloat();
        System.out.println("Quantité : ");
        int quantite = sc.nextInt();
        sc.nextLine();
        System.out.println("Date de restockage");
        String dateRestock = sc.nextLine();
        System.out.println("Durée de la batterie");
        String dureeBatterie = sc.nextLine();

        Electronique electronique = Electronique.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .batterieDuration(dureeBatterie)
                .build();

        electroniqueRepo.save(electronique);
    }
}

