package com.malvinas.comandoia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "localidad",nullable = false)
    String localidad;
    @Column(name = "barrio")
    String barrio;
    @Column(name = "calle")
    String calle;
    @Column(name = "numero_calle")
    int numero_calle;
}
