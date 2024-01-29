package com.pe.zenkai.AJMInventario.Repository;

import com.pe.zenkai.AJMInventario.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
