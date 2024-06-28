package org.example.tp_projet;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.repository.ClientRepo;

public class Main {
    public static void main(String[] args) {
        ClientRepo clientRepo = new ClientRepo();

        Client client = Client.builder()
                .nom("Ben")
                .prenom("Fatima")
                .build();

        clientRepo.save(client);



    }
}
