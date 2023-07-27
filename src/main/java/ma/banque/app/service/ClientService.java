package ma.banque.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.banque.app.iservice.IClient;
import ma.banque.app.entity.Client;
import ma.banque.app.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ClientService implements IClient {
    private ClientRepository clientRepository;

    @Override
    public Client create(Client object) {
        if (Objects.isNull(object)) return null;
        return this.clientRepository.save(object);
    }

    @Override
    public Client Update(Client object) {
        if (Objects.isNull(object)) return null;
        return this.clientRepository.save(object);
    }

    @Override
    public boolean delete(Client object) {
        if (Objects.isNull(object)) return false;
        this.clientRepository.delete(object);
        return true;
    }

    @Override
    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client findByCin(String cin) {
        return this.clientRepository.findByCin(cin);
    }

    @Override
    public Client findByEmail(String email) {
        return this.clientRepository.findByEmail(email);
    }
}
