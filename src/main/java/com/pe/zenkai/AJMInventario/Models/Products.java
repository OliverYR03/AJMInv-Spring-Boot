package com.pe.zenkai.AJMInventario.Models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "productos")
public class Products implements Serializable {
    private static final long serialVerseionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = true)
    private Integer idproducto;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;

    @Column(name = "cantidad")
    private Integer amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proveedorid", referencedColumnName = "idproveedor")
    private Suppliers suppliers;

    @Column(name = "precio")
    private Integer price;

    @Column(name = "imagen")
    private String img;

    @Column(name = "fechadeingre")
    private Date date;
}
