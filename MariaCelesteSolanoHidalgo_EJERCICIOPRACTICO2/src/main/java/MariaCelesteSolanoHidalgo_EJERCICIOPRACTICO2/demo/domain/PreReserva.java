/*
 * La clase PreReserva representa la entidad de base de datos "Prereservas".
 * Utiliza anotaciones JPA para mapear la clase a la tabla correspondiente en la base de datos.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Prereservas")
public class PreReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vuelo", nullable = false)
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
