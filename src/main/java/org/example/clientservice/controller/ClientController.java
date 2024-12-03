package org.example.clientservice.controller;

import org.example.clientservice.entite.Client;
import org.example.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200") // Permet les requêtes depuis le frontend Angular
@RestController
@RequestMapping("ClientService/api/clients") // Path global pour la classe
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Récupérer tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Récupérer un client par son ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // Sauvegarder un nouveau client
    @PostMapping
    public Client saveClient(@RequestBody Client client) {

        return clientService.saveClient(client);
    }

    // Mettre à jour un client existant
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id); // Mise à jour de l'ID avant de sauver
        return clientService.saveClient(client);
    }

    // Supprimer un client par son ID
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
