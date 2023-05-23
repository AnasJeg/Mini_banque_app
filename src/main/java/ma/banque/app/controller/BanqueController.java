package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import ma.banque.app.entity.Agence;
import ma.banque.app.entity.Client;
import ma.banque.app.entity.Compte;
import ma.banque.app.entity.Operation;
import ma.banque.app.service.BanqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Banque")
@RestController
@RequestMapping(value = "/banque/apis")
@AllArgsConstructor
@CrossOrigin("*")
public class BanqueController {
    private BanqueService banqueService;

    @PostMapping(value = "/createCompte")
    public Compte createCompte(Client client, Agence agence) {
        return banqueService.createCompte(client, agence);
    }

    @PostMapping(value = "/depotByNumeroCompte")
    public boolean depotByNumeroCompte(@RequestBody Compte compteCourant, @PathParam(value = "montant") double montant) {
        return banqueService.depotByNumeroCompte(compteCourant, montant);
    }

    @PostMapping(value = "/depotByCinClient")
    public boolean depotByCinClient(@RequestBody Client client, @PathParam(value = "montant") double montant) {
        return banqueService.depotByCinClient(client, montant);
    }

    @PostMapping(value = "/retraitByNumeroCompte")
    public boolean retraitByNumeroCompte(@RequestBody Compte compteCourant, @PathParam(value = "montant") double montant) {
        return banqueService.retraitByNumeroCompte(compteCourant, montant);
    }

    @PostMapping(value = "/retraitByCinClient")
    public boolean retraitByCinClient(@RequestBody Client client, @PathParam(value = "montant") double montant) {
        return banqueService.retraitByCinClient(client, montant);
    }

    @GetMapping(value = "/getSoldeByCompte")
    public double getSoldeByCompte(@PathParam(value = "numeroCompte") String numeroCompte) {
        return banqueService.getSoldeByCompte(numeroCompte);
    }

    @GetMapping(value = "/getOperationsByClient")
    public List<Operation> getOperationsByClient(@RequestBody Client client) {
        return banqueService.getOperationsByClient(client);
    }

    @PostMapping(value = "/viremantBetweenClientByNumeroCompte/{compteEnvoie}/{compteRecoit}")
    public boolean viremantBetweenClientByNumeroCompte(@PathVariable String compteEnvoie,@PathVariable String compteRecoit, @PathParam(value = "montant") double montant) {
        return banqueService.viremantBetweenClientByNumeroCompte2(compteEnvoie, compteRecoit, montant);
    }

    @PostMapping(value = "/viremantBetweenClientByCin")
    public boolean viremantBetweenClientByCin(@RequestBody Client clientEnvoie, @RequestBody Client clientRecoit, @PathParam(value = "montant") double montant) {
        return banqueService.viremantBetweenClientByCin(clientEnvoie, clientRecoit, montant);
    }
}
