package ma.banque.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import ma.banque.app.entity.Client;
import ma.banque.app.service.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clients")
@RestController
@RequestMapping(value = "/banque/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientController {
    private ClientService clientService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/create")
    public Client create(@RequestBody Client client) {
        client.setMotDePasse(passwordEncoder.encode(client.getMotDePasse()));
        return clientService.create(client);
    }

    @PutMapping(value = "/update")
    public Client Update(@RequestBody Client client) {
        return clientService.Update(client);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestBody Client client) {
        return clientService.delete(client);
    }

    @GetMapping(value = "/read")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping
    public Client findByCin(@PathParam(value = "cin") String cin) {
        return clientService.findByCin(cin);
    }
}
