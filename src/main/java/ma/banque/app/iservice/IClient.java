package ma.banque.app.iservice;

import ma.banque.app.entity.Client;
import ma.banque.app.imetier.IMetier;

public interface IClient extends IMetier<Client> {
    Client findByCin(String cin);

    Client findByEmail(String email);
}
