package br.com.enhmusical.client;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> list() {
        return repository.findAll(Sort.by("dateEvent", "timeEvent"));
    }

    public List<Client> searchByName(String nome) {
        return repository.findByCouplesNameContainingIgnoreCaseOrderByDateEventAsc(nome);
    }

    public List<Client> searchByTime(LocalDate start, LocalDate end) {
        return repository.findByDateEventBetweenOrderByDateEventAscTimeEventAsc(start, end);
    }

    public Client searchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + id));
    }

    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
