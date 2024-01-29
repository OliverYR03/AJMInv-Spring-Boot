package com.pe.zenkai.AJMInventario.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proveedores")
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    private Integer idproveedor;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "ruc")
    private Integer ruc;




}
