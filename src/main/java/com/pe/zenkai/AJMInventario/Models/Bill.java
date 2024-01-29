package com.pe.zenkai.AJMInventario.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "factura")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = true)
    private Integer numfactura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Client client;

    @Column(name = "fecha")
    private Date date;


}
