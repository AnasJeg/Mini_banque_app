package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import ma.banque.app.entity.Operation;
import ma.banque.app.service.OperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Operations")
@RestController
@RequestMapping(value = "/banque/operations")
@AllArgsConstructor
@CrossOrigin("*")
public class OperationController {
    private OperationService operationService;

    @PostMapping(value = "/create")
    public Operation create(@RequestBody Operation operation) {
        return operationService.create(operation);
    }

    @PutMapping(value = "/update")
    public Operation Update(@RequestBody Operation operation) {
        return operationService.Update(operation);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestBody Operation operation) {
        return operationService.delete(operation);
    }

    @GetMapping(value = "/read")
    public List<Operation> findAll() {
        return operationService.findAll();
    }

    @GetMapping("/compte")
    public List<Operation> findByCompteClientId(@PathParam(value = "id") String id){
        return operationService.findByCompteClientId(Integer.parseInt(id));
    }
}
