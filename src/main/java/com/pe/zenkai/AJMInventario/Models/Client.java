package com.pe.zenkai.AJMInventario.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cliente")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = true)
    private Integer idcliente;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;

    @Column(name = "direccion")
    private String addres;

    @Column(name = "fnacimiento")
    private Date borndate;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "email")
    private String email;


}
