package ma.banque.app.repository;

import ma.banque.app.entity.Client;
import ma.banque.app.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Compte findByNumeroCompte(String numeroCompte);

    Compte findById(int id);

    Compte findByClient_Id(int id);
}
