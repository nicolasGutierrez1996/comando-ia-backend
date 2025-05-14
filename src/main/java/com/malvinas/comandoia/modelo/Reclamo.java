package com.malvinas.comandoia.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reclamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_reclamo",nullable = false)
    private String tipo_reclamo;

    @Column(name = "fecha_reclamo")
    private LocalDateTime fecha_reclamo;

    @Column(name = "estado",length = 50)
    private String estado;

    @Column(name = "tiempo_resolucion")
    private int tiempo_resolucion;

    @Column(name = "nivel_satisfaccion")
    private int nivel_satisfaccion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_ultima_actualizacion")
    private LocalDateTime fecha_ultima_actualizacion;


    @ManyToOne(
            optional = false,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE }
    )
    @JoinColumn(name = "direccion_id", foreignKey = @ForeignKey(name = "FK_DIRECCION_ID"))
    private Direccion direccion;

    @PrePersist
    private void antesDePersistir(){
        this.fecha_creacion=LocalDateTime.now();
    }
    @PreUpdate
    private void antesDeModificar(){
        this.fecha_ultima_actualizacion=LocalDateTime.now();
    }

}
