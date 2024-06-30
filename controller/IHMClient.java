package org.example.tp_projet.controller;

import org.example.tp_projet.Service.ClientService;
import org.example.tp_projet.entity.Client;
import org.example.tp_projet.repository.ClientRepo;

import java.util.Scanner;



public class IHMClient {
    private Scanner sc;
    private ClientService clientService;
    private ClientRepo clientRepo;



    public IHMClient(Scanner sc) {
        this.sc = sc;
        clientService = new ClientService();
    }

    public void start (){
        String entry;
        while(true){
            System.out.println(" ---- Menu Client -----");
            System.out.println("1/ crée un client");
            System.out.println("2/ update un client");
            System.out.println("3/ supprimer un client");
            System.out.println("4/ recuperer un client par sont id");
            System.out.println("5/ recuperer tout les clients");
            entry = sc.nextLine();
            switch(entry){
                case "1"-> clientService.createClient();
                case "2"-> clientService.updateClient();
                case "3"-> clientService.delete();
                case "4"-> clientRepo.getById();
                case "5"-> clientService.getAll();
//                default -> {

                }
            }
        }
    }


//
//        Client client = clientService.create(nom,prenom);
//
//        System.out.println("client crée : " + client);
//    }
//
//    private void updateClient (){
//        System.out.println(" -- mise a jour d'un client --");
//        System.out.println("id du client :");
//        long id = sc.nextLong();
//        sc.nextLine();
//
//        Client client = clientService.findById(id);
//
//        System.out.println("nom ("+client.getNom()+") :");
//        String nom = sc.nextLine();
//        System.out.println("prenom ("+client.getPrenom()+") :");
//        String prenom = sc.nextLine();
//        System.out.println("age ("+client.getAge()+") :");
//        int age = sc.nextInt();
//        sc.nextLine();
//        System.out.println("telephone ("+client.getTelephone()+") :");
//        String telephone = sc.nextLine();
//        System.out.println("ville ("+client.getAdresse().getVille()+") :");
//        String ville = sc.nextLine();
//        System.out.println("rue ("+client.getAdresse().getRue()+") :");
//        String rue = sc.nextLine();
//
//
//        client = clientService.update(id,
//                nom != null? nom: client.getNom(),
//                prenom !=null? prenom : client.getPrenom(),
//                age != 0? age:client.getAge(),
//                telephone != null ? telephone : client.getTelephone(),
//                rue != null ? rue:client.getAdresse().getRue(),
//                ville != null? ville : client.getAdresse().getVille());
//        System.out.println("client modifié : "+client);
//    }
//
//    private void deleteClient (){
//        try{
//            System.out.println(" -- suppresion d'un client --");
//            System.out.println(" id du client a supprimer :");
//            long id = sc.nextLong();
//            sc.nextLine();
//
//            if(clientService.delete(id)){
//                System.out.println("CLient supprimé");
//            }
//            else{
//                System.out.println("erreure lors de la suppresion");
//            }
//        }catch (NotFoundException ex){
//            System.out.println(ex.getMessage());
//        }
//    }

