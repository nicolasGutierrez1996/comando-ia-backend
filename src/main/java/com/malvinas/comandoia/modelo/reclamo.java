package com.malvinas.comandoia.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reclamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "tipo_reclamo",nullable = false)
    String tipo_reclamo;
    @Column(name = "id_direccion")
    int id_direccion;
    @Column(name = "fecha_reclamo")
    int fecha_reclamo;
    @Column(name = "estado",length = 50)
    String estado;
    @Column(name = "tiempo_resolucion")
    int tiempo_resolucion;
    @Column(name = "nivel_sastifacion")
    int nivel_satisfacion;
    @Column(name = "fecha_creacion")
    int fecha_creacion;
    @Column(name = "fecha_ultima_actualizacion")
    int fecha_ultima_actualizacion;
    @Column(name = "estado_activo")
    boolean estado_activo;


}
