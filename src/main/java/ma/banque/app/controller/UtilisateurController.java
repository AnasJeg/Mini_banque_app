package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.banque.app.service.UtilisateurService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Utilisateurs")
@RestController
@RequestMapping(value = "/banque/utilisateurs")
@AllArgsConstructor
@CrossOrigin("*")
public class UtilisateurController {
    private UtilisateurService utilisateurService;
}
