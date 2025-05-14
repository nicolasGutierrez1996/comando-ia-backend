package com.malvinas.comandoia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "obraPublica")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class obraPublica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "nombre", nullable = false)
    String nombre;
    @Column(name = "tipo_obra", nullable = false, length = 100)
    String tipo_obra;
    @Column(name = "id_direccion")
    int id_direccion;
    @Column(name = "estado", nullable = false, length = 50)
    String estado;
    @Column(name = "avance_fisico")
    double avance_fisico;
    @Column(name = "monto_presupuesto")
    double monto_presupuesto;
    @Column(name = "monto_ejecutado")
    double monto_ejecutado;
    @Column(name = "fecha_inicio")
    int fecha_inicio;
    @Column(name = "fecha_estimada_finalizacion")
    int fecha_estimada_finalizacion;
    @Column(name = "fecha_real_finalizacion")
    int fecha_real_finalizacion;
    @Column(name = "fecha_creacion")
    int fecha_creacion;

}
