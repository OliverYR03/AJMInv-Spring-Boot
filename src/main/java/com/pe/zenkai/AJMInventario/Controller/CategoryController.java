package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;
import com.pe.zenkai.AJMInventario.Models.Category;
import com.pe.zenkai.AJMInventario.Repository.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public List<Category> categoryGetAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Category> getCategoryId(@PathVariable(value = "id") Integer idcategoria)
        throws ResourceNotFoundException {

        Category categories = categoryRepository.findById(idcategoria).orElseThrow(() ->
                new ResourceNotFoundException("Category not found for this id : :" + idcategoria));
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/new")
    public Category createCategory(@Validated @RequestBody Category categories)
    {
        return categoryRepository.save(categories);
    }
}
