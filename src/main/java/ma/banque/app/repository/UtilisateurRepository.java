package ma.banque.app.repository;

import ma.banque.app.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {


    Optional<Utilisateur> findByEmail(String email);

}
