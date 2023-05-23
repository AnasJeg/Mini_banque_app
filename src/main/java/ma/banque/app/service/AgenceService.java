package ma.banque.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.banque.app.iservice.IAgence;
import ma.banque.app.entity.Agence;
import ma.banque.app.repository.AgenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class AgenceService implements IAgence {
    private AgenceRepository agenceRepository;

    @Override
    public Agence create(Agence object) {
        if (Objects.isNull(object)) return null;
        return this.agenceRepository.save(object);
    }

    @Override
    public Agence Update(Agence object) {
        if (Objects.isNull(object)) return null;
        return this.agenceRepository.save(object);
    }

    @Override
    public boolean delete(Agence object) {
        if (Objects.isNull(object)) return false;
        this.agenceRepository.delete(object);
        return true;
    }

    @Override
    public List<Agence> findAll() {
        return this.agenceRepository.findAll();
    }

    @Override
    public void DeleteByID(int id) {
        this.agenceRepository.delete(this.agenceRepository.findById(id));
    }
}
