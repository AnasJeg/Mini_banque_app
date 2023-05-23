package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.banque.app.entity.Agence;
import ma.banque.app.service.AgenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Agences")
@RestController
@RequestMapping(value = "/banque/agences")
@AllArgsConstructor
@CrossOrigin("*")
public class AgenceController {
    private AgenceService agenceService;

    @PostMapping(value = "/create")
    public Agence create(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @PutMapping(value = "/update")
    public Agence Update(@RequestBody Agence agence) {
        return agenceService.Update(agence);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestBody Agence agence) {
        return agenceService.delete(agence);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        agenceService.DeleteByID(id);
    }
    @GetMapping(value = "/read")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }
}
