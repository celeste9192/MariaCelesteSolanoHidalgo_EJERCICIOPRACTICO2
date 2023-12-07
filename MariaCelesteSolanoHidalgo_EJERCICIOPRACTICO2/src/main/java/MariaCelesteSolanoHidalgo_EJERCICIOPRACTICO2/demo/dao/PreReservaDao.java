/*
 * La interfaz PreReservaDao extiende JpaRepository para realizar operaciones CRUD en la entidad PreReserva.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.PreReserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreReservaDao extends JpaRepository<PreReserva, Long> {

    // Método para buscar pre-reservas por cliente
    List<PreReserva> findByCliente(Cliente cliente);

    // Método para buscar pre-reservas por vuelo y cliente
    List<PreReserva> findByVueloAndCliente(Vuelo vuelo, Cliente cliente);

}
