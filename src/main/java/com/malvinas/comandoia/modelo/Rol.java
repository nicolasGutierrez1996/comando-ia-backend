package com.malvinas.comandoia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Rol")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
