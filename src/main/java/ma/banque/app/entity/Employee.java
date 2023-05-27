package ma.banque.app.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.banque.app.token.Token;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true)
public class Employee extends Personne {
    @Column(nullable = false, length = 10)
    private String matricule;


    public Employee(Integer id, String cin, String nom, String prenom, String adresse, String email, String telephone, Date dateNaissance, String motDePasse, Role role, List<Token> tokens, String matricule) {
        super(id, cin, nom, prenom, adresse, email, telephone, dateNaissance, motDePasse, role, tokens);
        this.matricule = matricule;
    }
}
