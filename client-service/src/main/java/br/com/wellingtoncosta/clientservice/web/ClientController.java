package br.com.wellingtoncosta.clientservice.web;

import br.com.wellingtoncosta.clientservice.domain.model.Client;
import br.com.wellingtoncosta.clientservice.domain.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Wellington Costa on 06/12/18
 */
@RestController public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @ApiOperation("Get all clients")
    @GetMapping(value = "/", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation("Get a client by id")
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @ApiOperation("Save a new client")
    @PostMapping(
            value = "/",
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return ResponseEntity.ok(service.save(client));
    }

    @ApiOperation("Update a client by id")
    @PutMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client client) {
        return ResponseEntity.ok(service.update(id, client));
    }

    @ApiOperation("Delete a client by id")
    @DeleteMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
