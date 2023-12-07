/*
 * La interfaz VueloDao extiende JpaRepository para realizar operaciones CRUD en la entidad Vuelo.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloDao extends JpaRepository<Vuelo, Long> {

    // Método para obtener todos los vuelos
    List<Vuelo> findAll();

    
}
