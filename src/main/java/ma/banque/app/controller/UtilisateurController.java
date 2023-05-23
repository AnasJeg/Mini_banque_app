package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.banque.app.entity.Utilisateur;
import ma.banque.app.repository.UtilisateurRepository;
import ma.banque.app.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Utilisateurs")
@RestController
@RequestMapping(value = "/banque/utilisateurs")
@AllArgsConstructor
@CrossOrigin("*")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/")
    public List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }
}
