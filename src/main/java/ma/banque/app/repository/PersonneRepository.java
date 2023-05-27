package ma.banque.app.repository;

import ma.banque.app.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    Optional<Personne> findByEmail(String email);
}
