package ma.banque.app.repository;

import ma.banque.app.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {

    List<Operation> findByCompteClientId (int id);
}
