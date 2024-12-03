package org.example.clientservice.service;




import org.example.clientservice.entite.Client;
import org.example.clientservice.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return (Client) clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return (Client) clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}