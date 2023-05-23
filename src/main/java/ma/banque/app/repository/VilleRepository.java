package ma.banque.app.repository;

import ma.banque.app.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {

        Ville findById(int id);
}
