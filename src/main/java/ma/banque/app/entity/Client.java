package ma.banque.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import ma.banque.app.token.Token;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true)
public class Client extends Personne {
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Compte> compte;


    public Client(Integer id, String cin, String nom, String prenom, String adresse, String email, String telephone, Date dateNaissance, String motDePasse, Role role, List<Token> tokens, List<Compte> compte) {
        super(id, cin, nom, prenom, adresse, email, telephone, dateNaissance,motDePasse,role, tokens );
        this.compte = compte;
    }
}
