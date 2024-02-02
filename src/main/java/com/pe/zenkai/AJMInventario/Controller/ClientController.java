package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;
import com.pe.zenkai.AJMInventario.Models.Client;
import com.pe.zenkai.AJMInventario.Repository.ClientRepository;
import jakarta.annotation.Resource;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clientes")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/list")
    public List<Client> getAllClient()
    {
        return clientRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Client> getClientId(@PathVariable(value = "id") Integer idcliente)
        throws ResourceNotFoundException{

        Client clients = clientRepository.findById(idcliente).orElseThrow(() ->
                new ResourceNotFoundException("Client not found for this id : :" + idcliente));
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/new")
    public Client createClient(@Validated @RequestBody Client clients)
    {
        return clientRepository.save(clients);
    }

    @PutMapping("/list/{id}")
    public ResponseEntity <Client> updateClient(@PathVariable(value = "id") Integer idcliente,
                                                @Validated @RequestBody Client clientDetails) throws ResourceNotFoundException{
        Client clients = clientRepository.findById(idcliente)
                .orElseThrow(() -> new ResourceNotFoundException(("Client not found for this id : :" + idcliente)));
        clients.setName(clientDetails.getName());

        final Client updateClient = clientRepository.save(clients);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/list/{id}")
    public Map<String, Boolean> deleteClient (@PathVariable (value = "id") Integer idcliente)
        throws ResourceNotFoundException{
        Client clients = clientRepository.findById(idcliente)
                .orElseThrow(() -> new ResourceNotFoundException(("Delete not complete, client not found for this id : :" + idcliente)));
        clientRepository.delete(clients);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The client for id" + idcliente + "deleted", Boolean.TRUE);
        return response;
    }

}
