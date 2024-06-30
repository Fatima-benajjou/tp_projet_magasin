package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.repository.NourritureRepo;

import java.util.List;
import java.util.Scanner;

public class NourritureService {


    private NourritureRepo nourritureRepo;

    public Nourriture create(String description, float prix, int quantite, String dateRestock, String datePeremp) {
        Nourriture nourriture = Nourriture.builder()
                .description(description)
                .prix(prix)
                .quantite(quantite)
                .dateRestock(dateRestock)
                .datePeremp(dateRestock)
                .build();
        return nourritureRepo.save(nourriture);

    }

    public Nourriture update(String description, float prix, int quantite, String dateRestock, String datePeremption) {
        Nourriture nourriture = nourritureRepo.getById(Nourriture.class, id);
        if (nourrtiure != null) {
            nourriture.setDescription(description);
            nourriture.setPrix(prix);
            nourriture.setQuantite(quantite);
            nourriture.setDateRestock(dateRestock);
            nourriture.setDatePeremption(datePeremption);
            nourriture.build();


            nourritureRepo.save(nourrtiure);
            return nourrtiure;
        }
        throw new NotFoundException("Aucun article a l'id :"+id);
    }

//@Override
        public boolean delete ( int id){
            Nourriture nourriture = nourritureRepo.getById(Nourriture.class, id);
            if (nourriture != null) {
                nourritureRepo.delete(nourriture);
                return true;
            }
            throw new EntityNotFoundException("ArticleNourriture non trouvé");
        }

        public Nourriture findById ( int id){
            Nourriture nourrtiure = nourritureRepo.getById(Nourriture.class, id);
            if (nourrtiure != null) {
                return nourrtiure;
            }
            throw new EntityNotFoundException("Article Nourriture non trouvé");

        }

        public List<Nourriture> getAll () {
            return nourritureRepo.getAll();
        }



        private Scanner sc = new Scanner(System.in);

        public void createNourriture () {
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


