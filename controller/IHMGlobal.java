package org.example.tp_projet.controller;

import java.util.Scanner;

public class IHMGlobal {
    Scanner sc = new Scanner(System.in);

    IHMClient ihmClient = new IHMClient(sc);
    IHMArticle ihmArticle = new IHMArticle(sc);


    public void start() {
        String entry;
        while (true) {
            System.out.println(" ---- Magasin -----");
            System.out.println("1/ Menu client");
            System.out.println("2/ Menu Article");
            System.out.println("3/ Menu Vente");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> ihmClient.start();
                case "2" -> ihmArticle.start();
                case "3" -> System.out.println("En cours de construction");
                default -> {
                    return;
                }
            }
        }
    }
}




