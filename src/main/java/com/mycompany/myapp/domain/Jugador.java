package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Jugador.
 */
@Entity
@Table(name = "jugador")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "canastas_totales")
    private Integer canastas_totales;

    @Column(name = "rebotes_totales")
    private Integer rebotes_totales;

    @Column(name = "asistencias_totales")
    private Integer asistencias_totales;

    @Column(name = "posicion")
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getCanastas_totales() {
        return canastas_totales;
    }

    public void setCanastas_totales(Integer canastas_totales) {
        this.canastas_totales = canastas_totales;
    }

    public Integer getRebotes_totales() {
        return rebotes_totales;
    }

    public void setRebotes_totales(Integer rebotes_totales) {
        this.rebotes_totales = rebotes_totales;
    }

    public Integer getAsistencias_totales() {
        return asistencias_totales;
    }

    public void setAsistencias_totales(Integer asistencias_totales) {
        this.asistencias_totales = asistencias_totales;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Jugador jugador = (Jugador) o;
        return Objects.equals(id, jugador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Jugador{" +
            "id=" + id +
            ", nombre='" + nombre + "'" +
            ", fecha_nacimiento='" + fecha_nacimiento + "'" +
            ", canastas_totales='" + canastas_totales + "'" +
            ", rebotes_totales='" + rebotes_totales + "'" +
            ", asistencias_totales='" + asistencias_totales + "'" +
            ", posicion='" + posicion + "'" +
            '}';
    }
}
