package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;
import com.pe.zenkai.AJMInventario.Models.Products;
import com.pe.zenkai.AJMInventario.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/list")
    public List<Products> getAllProductsModel() {
        return productsRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Products> getProductsModelId(@PathVariable(value = "id") Integer idProducto)
            throws ResourceNotFoundException {

        Products productos = productsRepository.findById(idProducto).orElseThrow(() ->
                new ResourceNotFoundException("Productos not found for this id : : " + idProducto));
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/new")
    public Products createProducts(@Validated @RequestBody Products products)
    {
        return productsRepository.save(products);
    }


    @PutMapping("/list/{id}")
    public ResponseEntity <Products> updateProductsModel(@PathVariable(value = "id") Integer idProducto,
                                                         @Validated @RequestBody Products productsDetails) throws ResourceNotFoundException{
        Products productos = productsRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("productos not found for this id : :" + idProducto));

        productos.setName(productsDetails.getName());

        final Products updateproductsModel = productsRepository.save(productos);
        return ResponseEntity.ok(updateproductsModel);
    }

    @DeleteMapping("/list/{id}")
    public Map<String, Boolean> deleteProductsModel (@PathVariable (value = "id") Integer idProducto)
            throws ResourceNotFoundException{
        Products productos = productsRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException(("Prveedor not found for this id : :" + idProducto)));
        productsRepository.delete(productos);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
