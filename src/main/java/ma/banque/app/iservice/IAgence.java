package ma.banque.app.iservice;

import ma.banque.app.entity.Agence;
import ma.banque.app.imetier.IMetier;

public interface IAgence extends IMetier<Agence> {

    void DeleteByID(int id);
}
