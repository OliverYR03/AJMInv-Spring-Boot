package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;
import com.pe.zenkai.AJMInventario.Models.ProductCat;
import com.pe.zenkai.AJMInventario.Repository.ProductCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/productcat")
@RestController
public class ProductCatController {
    
    @Autowired
    private ProductCatRepository productCatRepository;
    
    @GetMapping("/list")
    private List<ProductCat> getAllProductCat(){
        return productCatRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ProductCat> getDetailsId(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {

        ProductCat prodcat = productCatRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product Category not found for this id : :" + id));
        return ResponseEntity.ok(prodcat);
    }
}
