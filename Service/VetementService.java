package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Electronique;
import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.entity.Vetement;
import org.example.tp_projet.repository.NourritureRepo;
import org.example.tp_projet.repository.VetementRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Scanner;

public class VetementService {

    private VetementRepo vetementRepo = new VetementRepo();

    public Vetement create(String description, float prix, int quantite, String dateRestock) {
        Vetement vetement = Vetement.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .build();
        return vetementRepo.save(vetement);

    }

    public Vetement update() {
        System.out.println("Saisissez l'ID de l'article à modifier");
        Vetement vetement = vetementRepo.getById(Vetement.class, sc.nextInt());
        if (vetement != null) {
            System.out.println("Entrez une nouvelle description");
            vetement.setDescription(sc.nextLine());
            System.out.println("Entrez nouveau prix");
            vetement.setPrix(sc.nextInt());
            System.out.println("Entrez une nouvelle quantité");
            vetement.setQuantite(sc.nextInt());
            System.out.println("Entrez nouvelle date de reassort");
            vetement.setDateRestock(sc.nextLine());

            vetementRepo.save(vetement);
            return vetement;
        }
        throw new EntityNotFoundException("Article Vetement non trouvé");
    }

    //@Override
    public boolean delete() {
        System.out.println("Saissier l'Id a supprimer");
        Vetement vetement = vetementRepo.getById(Vetement.class, sc.nextInt());
        if (vetement != null) {
            vetementRepo.delete(vetement);
            return true;
        }
        throw new EntityNotFoundException("Article Vetement non trouvé");
    }

    public Vetement findById() {
        System.out.println("Saisisser l'ID que vous rechercher");
        Vetement vetement = vetementRepo.getById(Vetement.class, sc.nextInt());
        if (vetement != null) {
            return vetement;
        }
        throw new EntityNotFoundException("Article vetement non trouvé");

    }

    public void findAll(){
        List<Vetement> vetements = getAll();
        if(vetements == null)
            return;
        System.out.println(vetements);
    }

    public List<Vetement> getAll() {
        return vetementRepo.getAll();
    }


    private Scanner sc = new Scanner(System.in);

    public void createVetement() {
        System.out.println(" -- creation d'un Article Vetement --");
        System.out.println("Description Article :");
        String description = sc.nextLine();
        System.out.println("Prix :");
        Float prix = sc.nextFloat();
        System.out.println("Quantité : ");
        int quantite = sc.nextInt();
        sc.nextLine();
        System.out.println("Date de restockage");
        String dateRestock = sc.nextLine();


        Vetement vetement = Vetement.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .build();

        vetementRepo.save(vetement);


    }
}
