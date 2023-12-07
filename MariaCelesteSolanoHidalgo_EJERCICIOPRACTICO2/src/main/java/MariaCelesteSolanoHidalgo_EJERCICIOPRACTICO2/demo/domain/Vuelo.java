/*
 * La clase Vuelo representa la entidad del dominio para los vuelos en la aplicación.
 * Utiliza anotaciones JPA para mapear la clase a una tabla en la base de datos.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Vuelos")
public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_vuelo", nullable = false)
    private String numeroVuelo;

    @Column(nullable = false)
    private String destino;

    @Column(name = "lugar_salida", nullable = false)
    private String lugarSalida;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    @Column(name = "fecha_salida", nullable = false)
    private String fechaSalida;

    @Column(name = "fecha_llegada", nullable = false)
    private String fechaLlegada;

    @Column(name = "modelo_avion", nullable = false)
    private String modeloAvion;

    // Constructor vacío (necesario para JPA)
    public Vuelo() {
    }

    // Constructor con parámetros
    public Vuelo(String numeroVuelo, String destino, String lugarSalida, String horaSalida, String fechaSalida, String fechaLlegada, String modeloAvion) {
        this.numeroVuelo = numeroVuelo;
        this.destino = destino;
        this.lugarSalida = lugarSalida;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.modeloAvion = modeloAvion;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }
}
