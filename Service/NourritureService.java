package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Electronique;
import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.repository.NourritureRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Scanner;

public class NourritureService {


    private NourritureRepo nourritureRepo = new NourritureRepo();

    public Nourriture create(String description, float prix, int quantite, String dateRestock, String datePeremp) {
        Nourriture nourriture = Nourriture.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .datePeremption(dateRestock)
                .build();
        return nourritureRepo.save(nourriture);

    }

    public Nourriture update() {
        System.out.println("Entrez l'Id de l'article que vous souhaitez modifier");
        int id = sc.nextInt();
        Nourriture nourriture = nourritureRepo.getById(Nourriture.class, id);
        if (nourriture != null) {
            System.out.println("Entrez une nouvelle description");
            nourriture.setDescription(sc.nextLine());
            System.out.println("Entrez nouveau prix");
            nourriture.setPrix(sc.nextInt());
            System.out.println("Entrez une nouvelle quantité");
            nourriture.setQuantite(sc.nextInt());
            System.out.println("Entrez nouvelle date de reassort");
            nourriture.setDateRestock(sc.nextLine());
            System.out.println("Entrez la date de péremption");
            nourriture.setDatePeremption(sc.nextLine());

            nourritureRepo.save(nourriture);
            return nourriture;
        }
        throw new EntityNotFoundException("Aucun article a l'id :" + id);
    }

    //@Override
    public boolean delete() {
        System.out.println("veuillez saisir l'ID de l'article à supprimer");
        Nourriture nourriture = nourritureRepo.getById(Nourriture.class, sc.nextInt());
        if (nourriture != null) {
            nourritureRepo.delete(nourriture);
            return true;
        }
        throw new EntityNotFoundException("ArticleNourriture non trouvé");
    }

    public Nourriture findById() {
        System.out.println("Saisir l'id que vous souhaitez trouver");
        Nourriture nourrtiure = nourritureRepo.getById(Nourriture.class, sc.nextInt());
        if (nourrtiure != null) {
            return nourrtiure;
        }
        throw new EntityNotFoundException("Article Nourriture non trouvé");

    }

    public void findAll() {
        List<Nourriture> nourritures = getAll();
        if (nourritures == null)
            return;
        System.out.println(nourritures);
    }

    public List<Nourriture> getAll() {
        return nourritureRepo.getAll();
    }


    private Scanner sc = new Scanner(System.in);

    public void createNourriture() {
        System.out.println(" -- creation d'un Article Nourriture --");
        System.out.println("Description Article :");
        String description = sc.nextLine();
        System.out.println("Prix :");
        Float prix = sc.nextFloat();
        System.out.println("Quantité : ");
        int quantite = sc.nextInt();
        sc.nextLine();
        System.out.println("Date de restockage");
        String dateRestock = sc.nextLine();
        System.out.println("Date de péremption");
        String datePeremp = sc.nextLine();


        Nourriture nourriture = Nourriture.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .datePeremption(datePeremp)
                .build();

        nourritureRepo.save(nourriture);


    }
}


