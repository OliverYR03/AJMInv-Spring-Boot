package com.pe.zenkai.AJMInventario.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "productos_categorias")
public class ProductCat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = true)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idproducto", referencedColumnName = "idProducto")
    private Products idproducto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Category idcategoria;



}
