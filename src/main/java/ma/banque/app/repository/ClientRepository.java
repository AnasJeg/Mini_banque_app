package ma.banque.app.repository;

import ma.banque.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByCin(String cin);

    Client findByEmail(String email);
}
