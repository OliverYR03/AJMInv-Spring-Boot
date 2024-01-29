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
@Table(name = "detalle")
public class Details implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = true)
    private Integer numdetalle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idfactura", referencedColumnName = "numfactura")
    private Bill idbill;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idproducto", referencedColumnName = "idProducto")
    private Products idproduct;

    @Column(name = "cantidad")
    private Integer amount;

    @Column(name = "precio")
    private Integer price;

}

