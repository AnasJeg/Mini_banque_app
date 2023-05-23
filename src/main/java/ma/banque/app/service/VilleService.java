package ma.banque.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.banque.app.iservice.IVille;
import ma.banque.app.entity.Ville;
import ma.banque.app.repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class VilleService implements IVille {
    private VilleRepository villeRepository;

    @Override
    public Ville create(Ville object) {
        if (Objects.isNull(object)) return null;
        return this.villeRepository.save(object);
    }

    @Override
    public Ville Update(Ville object) {
        if (Objects.isNull(object)) return null;
        return this.villeRepository.save(object);
    }

    @Override
    public boolean delete(Ville object) {
        if (Objects.isNull(object)) return false;
        this.villeRepository.delete(object);
        return true;
    }

    @Override
    public List<Ville> findAll() {
        return this.villeRepository.findAll();
    }

    @Override
    public void DeleteByID(int id) {
        this.villeRepository.delete(this.villeRepository.findById(id));
    }
}
