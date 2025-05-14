package com.malvinas.comandoia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "obra_publica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraPublica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo_obra", nullable = false, length = 100)
    private String tipo_obra;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "avance_fisico")
    private double avance_fisico;

    @Column(name = "monto_presupuestado")
    private BigDecimal monto_presupuestado;

    @Column(name = "monto_ejecutado")
    private BigDecimal monto_ejecutado;

    @Column(name = "fecha_inicio")
    private LocalDateTime fecha_inicio;

    @Column(name = "fecha_estimada_finalizacion")
    private LocalDateTime fecha_estimada_finalizacion;

    @Column(name = "fecha_real_finalizacion")
    private LocalDateTime fecha_real_finalizacion;

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