package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.entity.Vetement;
import org.example.tp_projet.repository.NourritureRepo;
import org.example.tp_projet.repository.VetementRepo;

import java.util.List;
import java.util.Scanner;

public class VetementService {

    private VetementRepo vetementRepo;

    public Vetement create(String description, float prix, int quantite, String dateRestock) {
        Vetement vetement = Vetement.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .build();
        return vetementRepo.save(vetement);

    }

    public Vetement update(String description, float prix, int quantite, String dateRestock) {
        Vetement vetement = vetementRepo.getById(Nourriture.class, id);
        if (vetement != null) {
            vetement.setDescription(description);
            vetement.setPrix(prix);
            vetement.setQuantite(quantite);
            vetement.setDateRestock(dateRestock);
            vetement.build();


            vetementRepo.save(vetement);
            return vetement;
        }
        throw new NotFoundException("Aucun article a l'id :"+id);
    }

    //@Override
    public boolean delete ( int id){
        Vetement vetement = vetementRepo.getById(Nourriture.class, id);
        if (vetement != null) {
            vetementRepo.delete(vetement);
            return true;
        }
        throw new EntityNotFoundException("Article Vetement non trouvé");
    }

    public Nourriture findById ( int id){
        Vetement vetement = vetementRepo.getById(Vetement.class, id);
        if (vetement != null) {
            return vetement;
        }
        throw new EntityNotFoundException("Article vetement non trouvé");

    }

    public List<Vetement> getAll () {
        return vetementRepo.getAll();
    }



    private Scanner sc = new Scanner(System.in);

    public void createNourriture () {
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
