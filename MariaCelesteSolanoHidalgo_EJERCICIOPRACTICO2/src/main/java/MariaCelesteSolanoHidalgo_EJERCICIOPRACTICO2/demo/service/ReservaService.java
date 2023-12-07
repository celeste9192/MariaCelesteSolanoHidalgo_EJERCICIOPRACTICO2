/*
 * La interfaz ReservaService define los métodos que deben ser implementados por las clases que proporcionan servicios relacionados con las reservas.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Reserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    
    // Obtener todas las reservas
    List<Reserva> getAllReservas();

    // Obtener una reserva por su ID
    Optional<Reserva> getReservaById(Long id);

    // Obtener reservas por cliente
    List<Reserva> getReservasByCliente(Cliente cliente);

    // Obtener reservas por vuelo y cliente
    List<Reserva> getReservasByVueloAndCliente(Vuelo vuelo, Cliente cliente);

    // Guardar una nueva reserva
    void saveReserva(Reserva reserva);

    // Eliminar una reserva por su ID
    void deleteReserva(Long id);
}
