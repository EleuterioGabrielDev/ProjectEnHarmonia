package br.com.enhmusical;

import br.com.enhmusical.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByCouplesNameContainingIgnoreCaseOrderByDateEventAsc(String couplesName);

    List<Client> findByDateEventBetweenOrderByDateEventAscTimeEventAsc(
            LocalDate start, LocalDate end);
}
