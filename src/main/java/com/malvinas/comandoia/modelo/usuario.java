package com.malvinas.comandoia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "nombre", nullable = false)
    String nombre;
    @Column(name = "email", nullable = false, unique = true )
    String email;
    @Column(name = "contraseña", nullable = false)
    String contraseña;
    @Column(name = "fecha_creaccion")
    int fecha_creaccion;
    @Column(name = "fecha_ultima_actualizacion")
    int fecha_ultima_actualizacion;
    @Column(name = "estado")
    boolean estado;
    int id_rol;


}
