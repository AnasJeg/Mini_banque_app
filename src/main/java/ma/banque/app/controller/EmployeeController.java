package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.banque.app.entity.Employee;
import ma.banque.app.service.EmployeeService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Employees")
@RestController
@RequestMapping(value = "/banque/employees")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeService employeeService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/create")
    public Employee create(@RequestBody Employee employee) {
        employee.setMotDePasse(passwordEncoder.encode(employee.getMotDePasse()));
        return employeeService.create(employee);
    }

    @PutMapping(value = "/update")
    public Employee Update(@RequestBody Employee employee) {
        return employeeService.Update(employee);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestBody Employee employee) {
        return employeeService.delete(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
         employeeService.DeleteByID(id);
    }
    @PutMapping("/update/{id}")
    public Employee updateCity(@PathVariable int id, @RequestBody Employee employee) {
        Employee existingEmploye = employeeService.findById(id);
        if (existingEmploye != null) {
            employeeService.Update(employee);
        }
        return null;
    }
    @GetMapping(value = "/read")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
