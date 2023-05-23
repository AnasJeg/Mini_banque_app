package ma.banque.app.iservice;

import ma.banque.app.entity.Employee;
import ma.banque.app.imetier.IMetier;

public interface IEmployee extends IMetier<Employee> {

          void  DeleteByID(int id);

          Employee findById(int id);
}
