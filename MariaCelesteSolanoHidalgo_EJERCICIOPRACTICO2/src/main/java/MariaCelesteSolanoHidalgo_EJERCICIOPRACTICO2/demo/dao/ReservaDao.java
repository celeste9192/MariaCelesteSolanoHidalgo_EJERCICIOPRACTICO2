/*
 * La interfaz ReservaDao extiende JpaRepository para realizar operaciones CRUD en la entidad Reserva.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Reserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaDao extends JpaRepository<Reserva, Long> {

    // Método para buscar reservas por cliente
    List<Reserva> findByCliente(Cliente cliente);

    // Método para buscar reservas por vuelo y cliente
    List<Reserva> findByVueloAndCliente(Vuelo vuelo, Cliente cliente);

   
}
