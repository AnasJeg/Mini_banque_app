package ma.banque.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.banque.app.iservice.IEmployee;
import ma.banque.app.entity.Employee;
import ma.banque.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService implements IEmployee {
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee object) {
        if (Objects.isNull(object)) return null;
        return this.employeeRepository.save(object);
    }

    @Override
    public Employee Update(Employee object) {
        if (Objects.isNull(object)) return null;
        return this.employeeRepository.save(object);
    }

    @Override
    public boolean delete(Employee object) {
        if (Objects.isNull(object)) return false;
        this.employeeRepository.delete(object);
        return true;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void DeleteByID(int id) {
        this.employeeRepository.delete(this.employeeRepository.findById(id));
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }
}
