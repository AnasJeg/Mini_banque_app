package ma.banque.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.banque.app.iservice.IOperation;
import ma.banque.app.entity.Operation;
import ma.banque.app.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class OperationService implements IOperation {
    private OperationRepository operationRepository;

    @Override
    public Operation create(Operation object) {
        if (Objects.isNull(object)) return null;
        return this.operationRepository.save(object);
    }

    @Override
    public Operation Update(Operation object) {
        if (Objects.isNull(object)) return null;
        return this.operationRepository.save(object);
    }

    @Override
    public boolean delete(Operation object) {
        if (Objects.isNull(object)) return false;
        this.operationRepository.delete(object);
        return true;
    }

    @Override
    public List<Operation> findAll() {
        return this.operationRepository.findAll();
    }

    public List<Operation> findByCompteClientId(int id) {
        return this.operationRepository.findByCompteClientId(id);
    }

}
