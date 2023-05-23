package ma.banque.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.banque.app.iservice.IBanque;
import ma.banque.app.entity.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BanqueService implements IBanque {
    private CompteService compteService;
    private OperationService operationService;
    private ClientService clientService;
    private AgenceService agenceService;

    @Override
    public Compte createCompte(Client client, Agence agence) {
        return this.operationService.create(Creation.builder()
                .code("")
                .date(new Date())
                .montant(0)
                .compte(this.compteService.create(CompteCourant.builder()
                        .numeroCompte("")
                        .solde(0)
                        .agence(agence)
                        .client(this.clientService.create(client))
                        .build()
                ))
                .build()
        ).getCompte();
    }

    @Override
    public List<Operation> getOperationsByClient(Client client) {
        if (Objects.isNull(client)) return null;
        return this.clientService.findByCin(client.getCin()).getCompte().stream().filter(c -> c instanceof CompteCourant).map(Compte::getOperations).findFirst().orElse(null);
    }

    @Override
    public double getSoldeByCompte(String numeroCompte) {
        return this.compteService.findByNumeroCompte(numeroCompte).getSolde();
    }

    @Override
    public boolean depotByNumeroCompte(Compte compteCourant, double montant) {
        if (!Objects.isNull(compteCourant)) {
            Compte compte = this.compteService.findByNumeroCompte(compteCourant.getNumeroCompte());
            if (!Objects.isNull(compte)) {
                compte.setSolde(compte.getSolde() + montant);
                this.operationService.create(Depot.builder()
                      //  .code("")
                        .date(new Date())
                        .montant(montant)
                        .compte(compte)
                        .build()
                );
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean depotByCinClient(Client client, double montant) {
        if (!Objects.isNull(client)) {
            List<Compte> comptes = this.clientService.findByCin(client.getCin()).getCompte();
            Compte compte = comptes.stream().filter(c -> c instanceof CompteCourant).findFirst().orElse(null);
            if (!Objects.isNull(compte)) {
                compte.setSolde(compte.getSolde() + montant);
                this.operationService.create(Depot.builder()
                    //    .code("")
                        .date(new Date())
                        .montant(montant)
                        .compte(compte)
                        .build()
                );
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retraitByNumeroCompte(Compte compteCourant, double montant) {
        if (!Objects.isNull(compteCourant)) {
            Compte compte = this.compteService.findByNumeroCompte(compteCourant.getNumeroCompte());
            if (!Objects.isNull(compte)) {
                if (compte.getSolde() >= montant) {
                    compte.setSolde(compte.getSolde() - montant);
                    this.operationService.create(Retrait.builder()
                       //     .code("")
                            .date(new Date())
                            .montant(montant)
                            .compte(compte)
                            .build()
                    );
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean retraitByCinClient(Client client, double montant) {
        if (!Objects.isNull(client)) {
            List<Compte> comptes = this.clientService.findByCin(client.getCin()).getCompte();
            Compte compte = comptes.stream().filter(c -> c instanceof CompteCourant).findFirst().orElse(null);
            if (!Objects.isNull(compte)) {
                if (compte.getSolde() >= montant) {
                    compte.setSolde(compte.getSolde() - montant);
                    this.operationService.create(
                            Retrait.builder()
                          //  .code("")
                            .date(new Date())
                            .montant(montant)
                            .compte(compte)
                            .build()
                    );
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean viremantBetweenClientByNumeroCompte(Compte compteEnvoie, Compte compteRecoit, double montant) {
        if (!Objects.isNull(compteEnvoie) && !Objects.isNull(compteRecoit)) {
            this.retraitByNumeroCompte(compteEnvoie, montant);
            this.depotByNumeroCompte(compteRecoit, montant);
            return true;
        }
        return false;
    }


    public boolean viremantBetweenClientByNumeroCompte2(String compteEnvoie, String compteRecoit, double montant) {
       Compte compteE = compteService.findByNumeroCompte(compteEnvoie);
       Compte compteR = compteService.findByNumeroCompte(compteRecoit);
        if (!Objects.isNull(compteE) && !Objects.isNull(compteR)) {
            this.retraitByNumeroCompte(compteE, montant);
            this.depotByNumeroCompte(compteR, montant);
            return true;
        }
        return false;
    }

    @Override
    public boolean viremantBetweenClientByCin(Client clientEnvoie, Client clientRecoit, double montant) {
        if (!Objects.isNull(clientEnvoie) && !Objects.isNull(clientRecoit)) {
            this.retraitByCinClient(clientEnvoie, montant);
            this.depotByCinClient(clientRecoit, montant);
            return true;
        }
        return false;
    }
}
