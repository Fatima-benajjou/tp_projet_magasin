package org.example.tp_projet.controller;

import org.example.tp_projet.Service.ClientService;
import org.example.tp_projet.Service.ElectroniqueService;
import org.example.tp_projet.Service.NourritureService;
import org.example.tp_projet.Service.VetementService;
import org.example.tp_projet.repository.ElectroniqueRepo;
import org.example.tp_projet.repository.NourritureRepo;
import org.example.tp_projet.repository.VetementRepo;

import java.util.Scanner;

public class IHMArticle {

    private NourritureService nourritureService = new NourritureService();
    private VetementService vetementService = new VetementService();
    private ElectroniqueService electroniqueService = new ElectroniqueService();

    Scanner sc = new Scanner(System.in);

    public IHMArticle(Scanner sc) {
        this.sc = sc;
        nourritureService = new NourritureService();
        electroniqueService = new ElectroniqueService();
        vetementService = new VetementService();
    }

    public void start() {

        String entry;
        String entryChoix;


        System.out.println(" ---- Menu Article -----");

        System.out.println("Quel catégorie d'Article est concerné");
        System.out.println("1/ Nourriture");
        System.out.println("2/ Vetement");
        System.out.println("3/ Electronique");
        entry = sc.nextLine();

        switch (entry) {
            case "1":
                System.out.println(" ---- Menu Article Catégorie Nourriture -----");
                System.out.println("1/ crée un Article");
                System.out.println("2/ update un Article");
                System.out.println("3/ supprimer un Article");
                System.out.println("4/ recuperer un Article par sont id");
                System.out.println("5/ recuperer tout les Article");
                entryChoix = sc.nextLine();
                choixNourritureCRUD(entryChoix);
                break;
            case "2": // Vetement
                System.out.println(" ---- Menu Article Catégorie Vetement -----");
                System.out.println("1/ crée un Article");
                System.out.println("2/ update un Article");
                System.out.println("3/ supprimer un Article");
                System.out.println("4/ recuperer un Article par sont id");
                System.out.println("5/ recuperer tout les Article");
                entryChoix = sc.nextLine();
                choixVetementCRUD(entryChoix);
                break;
            case "3":// Electronique
                System.out.println(" ---- Menu Article Catégorie Vetement -----");
                System.out.println("1/ crée un Article");
                System.out.println("2/ update un Article");
                System.out.println("3/ supprimer un Article");
                System.out.println("4/ recuperer un Article par sont id");
                System.out.println("5/ recuperer tout les Article");
                entryChoix = sc.nextLine();
                choixElectroniqueCRUD(entryChoix);
                break;
            default:
                System.out.println("Saisie erroné, recommencez");
                break;
        }

    }


    private void choixNourritureCRUD(String entryChoix) {
        switch (entryChoix) {

            case "1" -> nourritureService.createNourriture();
            case "2" -> nourritureService.update();
            case "3" -> nourritureService.delete();
            case "4" -> nourritureService.findById();
            case "5" -> nourritureService.findAll();
            default -> System.out.println("Saisie erroné, recommencez");
        }

    }

    private void choixVetementCRUD(String entry) {
        switch (entry) {
            case "1" -> vetementService.createVetement();
            case "2" -> vetementService.update();
            case "3" -> vetementService.delete();
            case "4" -> vetementService.findById();
            case "5" -> vetementService.findAll();
            default -> System.out.println("Saisie erroné, recommencez");

        }
    }

    private void choixElectroniqueCRUD(String entry) {
        switch (entry) {
            case "1" -> electroniqueService.createElectronique();
            case "2" -> electroniqueService.update();
            case "3" -> electroniqueService.delete();
            case "4" -> electroniqueService.findById();
            case "5" -> electroniqueService.findAll();
            default -> System.out.println("Saisie erroné, recommencez");

        }
    }
}




