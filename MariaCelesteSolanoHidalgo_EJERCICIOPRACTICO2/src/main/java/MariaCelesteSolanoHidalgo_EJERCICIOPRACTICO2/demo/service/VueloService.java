/*
 * La interfaz VueloService define los métodos que deben ser implementados por las clases que proporcionan servicios relacionados con los vuelos.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;

import java.util.List;
import java.util.Optional;

public interface VueloService {

    // Obtener todos los vuelos
    List<Vuelo> getAllVuelos();

    // Obtener un vuelo por su ID
    Optional<Vuelo> getVueloById(Long id);

    // Guardar un nuevo vuelo
    void saveVuelo(Vuelo vuelo);

    // Eliminar un vuelo por su ID
    void deleteVuelo(Long id);
}
