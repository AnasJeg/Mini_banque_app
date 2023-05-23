package ma.banque.app.repository;

import ma.banque.app.entity.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

        Agence findById(int id);
}
