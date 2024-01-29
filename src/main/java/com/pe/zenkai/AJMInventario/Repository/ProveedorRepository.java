package com.pe.zenkai.AJMInventario.Repository;

import com.pe.zenkai.AJMInventario.Models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository <Suppliers, Integer> {
}
