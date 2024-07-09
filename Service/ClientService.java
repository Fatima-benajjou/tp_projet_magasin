package org.example.tp_projet.Service;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.repository.ClientRepo;
import org.hibernate.annotations.NotFound;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Scanner;


public class ClientService {
    private Scanner sc = new Scanner(System.in);
    private Client client;
    private ClientRepo clientRepo = new ClientRepo();

    public Client create(String nom, String prenom) {
        Client client = Client.builder()
                .nom(nom)
                .prenom(prenom)
                .build();

        return clientRepo.save(client);

    }

    public Client update() {
        System.out.println("entrez l'id client :");
        int id = sc.nextInt();

        Client client = clientRepo.getById(Client.class, id);
        if (client != null) {
            System.out.println("entrez un nouveau nom (" +client.getNom()+") :");
            client.setNom(sc.nextLine());
            System.out.println("entrez un nouveau prénom (" +client.getPrenom()+") :");
            client.setPrenom(sc.nextLine());

            clientRepo.save(client);
            return client;
        }
        throw new EntityNotFoundException("Client non trouvé");

    }

    public boolean delete() {
        System.out.println("Veuillez saisir l'Id du client a supprimer");
        Client client = clientRepo.getById(Client.class, sc.nextInt());
        if (client != null) {
            clientRepo.delete(client);
            return true;
        }

        throw new EntityNotFoundException("Client non trouvé");
    }

    public Client findById () {
        System.out.println("Saisirl'ID que vous souhaitez trouver");
        Client client = clientRepo.getById(Client.class, sc.nextInt());
        if (client != null) {
            return client;
        }
        throw new EntityNotFoundException("Client non trouvé");

    }

    public void findAll(){
        List<Client> clients = getAll();
        if(clients == null)
            return;

        System.out.println(clients);
    }

        public List<Client> getAll() {
        return clientRepo.getAll();
    }


    public void createClient() {
        System.out.println(" -- creation d'un client --");
        System.out.println("nom :");
        String nom = sc.nextLine();
        System.out.println("prenom :");
        String prenom = sc.nextLine();

        Client client = Client.builder()
                .nom(nom)
                .prenom(prenom)
                .build();
        clientRepo.save(client);

    }
}
