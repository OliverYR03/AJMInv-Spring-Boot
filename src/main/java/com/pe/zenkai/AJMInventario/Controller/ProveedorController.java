package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Models.Suppliers;
import com.pe.zenkai.AJMInventario.Repository.ProveedorRepository;
import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200") // conectar a angular peruano  || 3000 for react

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/list")
    public List<Suppliers> getAllSuppliers()
    {
        return proveedorRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Suppliers> getSuppliersId(@PathVariable (value = "id") Integer idProveedor)
        throws ResourceNotFoundException{

        Suppliers proveedor = proveedorRepository.findById(idProveedor).orElseThrow(() ->
        new ResourceNotFoundException("Proveedor not found for this id : : " + idProveedor));
        return ResponseEntity.ok(proveedor);
    }

    @PostMapping("nuevo")
    public Suppliers createSuppliers(@Validated @RequestBody Suppliers Suppliers)
    {
        return proveedorRepository.save(Suppliers);
    }

    @PutMapping("/list/{id}")
    public ResponseEntity <Suppliers> updateSuppliers(@PathVariable(value = "id") Integer idProveedor,
                                                           @Validated @RequestBody Suppliers proveedorDetails) throws ResourceNotFoundException{
    Suppliers Suppliers = proveedorRepository.findById(idProveedor)
    .orElseThrow(() -> new ResourceNotFoundException("Proveedor not found for this id : :" + idProveedor));

    Suppliers.setName(proveedorDetails.getName());

    final Suppliers updateSuppliers = proveedorRepository.save(Suppliers);
    return ResponseEntity.ok(updateSuppliers);
    }

    @DeleteMapping("/list/{id}")
    public Map<String, Boolean> deleteSuppliers (@PathVariable (value = "id") Integer idProveedor)
        throws ResourceNotFoundException{
        Suppliers Suppliers = proveedorRepository.findById(idProveedor)
                .orElseThrow(() -> new ResourceNotFoundException(("Prveedor not found for this id : :" + idProveedor)));
        proveedorRepository.delete(Suppliers);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
