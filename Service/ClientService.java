package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.repository.ClientRepo;
import org.hibernate.annotations.NotFound;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Scanner;


public class ClientService {

    private ClientRepo clientRepo;

    public Client create(String nom, String prenom) {
        Client client = Client.builder()
                .nom(nom)
                .prenom(prenom)
                .build();

        return clientRepo.save(client);

    }

    public boolean delete(int id) {
        Client client = clientRepo.getById(Client.class, id);
        if (client != null) {
            clientRepo.delete(client);
            return true;
        }
        throw new EntityNotFoundException("Client non trouvé");
    }

    public Client findById(int id) {
        Client client = clientRepo.getById(Client.class, id);
        if (client != null) {
            return client;
        }
        throw new EntityNotFoundException("Client non trouvé");

    }

    public List<Client> getAll() {
        return clientRepo.getAll();
    }


    private Scanner sc = new Scanner(System.in);

    public void createClient() {
        System.out.println(" -- creation d'un client --");
        System.out.println("nom :");
        String nom = sc.nextLine();
        System.out.println("prenom :");
        String prenom= sc.nextLine();

        Client client = Client.builder()
                .nom(nom)
                .prenom(prenom)
                .build();
        clientRepo.save(client);

    }
}
