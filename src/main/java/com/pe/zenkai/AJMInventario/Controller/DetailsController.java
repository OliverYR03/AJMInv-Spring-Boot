package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;
import com.pe.zenkai.AJMInventario.Models.Details;
import com.pe.zenkai.AJMInventario.Models.Details;
import com.pe.zenkai.AJMInventario.Repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/detalles")
public class DetailsController {
    
    @Autowired
    private DetailsRepository detailsRepository;
    
    @GetMapping("/list")
    public List<Details> getAllDetails()
    {
        return detailsRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Details> getDetailsId(@PathVariable(value = "id") Integer numdetalle)
            throws ResourceNotFoundException {

        Details details = detailsRepository.findById(numdetalle).orElseThrow(() ->
                new ResourceNotFoundException("Details not found for this id : :" + numdetalle));
        return ResponseEntity.ok(details);
    }

    @PostMapping("/new")
    public Details createDetails(@Validated @RequestBody Details details)
    {
        return detailsRepository.save(details);
    }

    @PutMapping("/list/{id}")
    public ResponseEntity <Details> updateDetails(@PathVariable(value = "id") Integer numdetalle,
                                                @Validated @RequestBody Details detailDetails) throws ResourceNotFoundException{
        Details details = detailsRepository.findById(numdetalle)
                .orElseThrow(() -> new ResourceNotFoundException(("Details not found for this id : :" + numdetalle)));
        details.setIdbill(detailDetails.getIdbill());

        final Details updateDetails = detailsRepository.save(details);
        return ResponseEntity.ok(updateDetails);
    }

    @DeleteMapping("/list/{id}")
    public Map<String, Boolean> deleteClient (@PathVariable (value = "id") Integer numdetalle)
            throws ResourceNotFoundException{
        Details details = detailsRepository.findById(numdetalle)
                .orElseThrow(() -> new ResourceNotFoundException(("Delete not complete, client not found for this id : :" + numdetalle)));
        detailsRepository.delete(details);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The detail for id" + numdetalle + "deleted", Boolean.TRUE);
        return response;
    }
}
