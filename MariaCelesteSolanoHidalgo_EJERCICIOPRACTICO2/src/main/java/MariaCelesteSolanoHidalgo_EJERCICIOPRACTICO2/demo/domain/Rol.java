/*
 * La clase Rol representa la entidad de base de datos "Roles".
 * Utiliza anotaciones JPA para mapear la clase a la tabla correspondiente en la base de datos.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Getters and Setters
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
}
