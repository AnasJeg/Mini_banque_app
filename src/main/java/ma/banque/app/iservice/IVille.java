package ma.banque.app.iservice;

import ma.banque.app.entity.Ville;
import ma.banque.app.imetier.IMetier;

public interface IVille extends IMetier<Ville> {

    void DeleteByID(int id);
}
