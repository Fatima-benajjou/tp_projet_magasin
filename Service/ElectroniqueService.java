package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Electronique;
import org.example.tp_projet.repository.ElectroniqueRepo;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Scanner;

public class ElectroniqueService {

    private ElectroniqueRepo electroniqueRepo;

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

    public Electronique update(String description, float prix,
                               int quantite, String dateRestock, String batterieDuration) {
        Electronique electronique = electroniqueRepo.getById(Electronique.class, id);

        if (electronique != null) {
            electronique.setDescription(description);
            electronique.setPrix(prix);
            electronique.setQuantie(quantite);
            electronique.setDateRestock(dateRestock);
            electronique.setDate(batterieDuration);

            electroniqueRepo.save(electronique);
            return electronique;
        }
        throw new NotFoundException("Aucun article a l'id :" + id);
    }

    public boolean delete(int id) {
        Electronique electronique = electroniqueRepo.getById(Electronique.class, id);
        if (electronique != null) {
            electroniqueRepo.delete(electronique);
            return true;
        }
        throw new EntityNotFoundException("Article non trouvé");
    }

    public Electronique findById(int id) {
        Electronique electronique = electroniqueRepo.getById(Electronique.class, id);
        return electronique;
    }
    throw new

    EntityNotFoundException("Aucun article trouvé pour cet ID")


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
                .durationBatterie(dureeBatterie)
                .build();

        electroniqueRepo.save(electronique);
    }
}

