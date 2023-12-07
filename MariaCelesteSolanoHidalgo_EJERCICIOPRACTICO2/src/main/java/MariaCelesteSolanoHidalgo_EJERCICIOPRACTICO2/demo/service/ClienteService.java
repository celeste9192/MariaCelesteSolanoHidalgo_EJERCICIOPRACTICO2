/*
 * Interfaz ClienteService que define las operaciones relacionadas con la entidad Cliente.
 * Proporciona métodos para obtener clientes, buscar por ID y nombre de usuario, guardar y eliminar clientes.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    // Obtener todos los clientes
    List<Cliente> getAllClientes();

    // Obtener un cliente por su ID
    Optional<Cliente> getClienteById(Long id);

    // Obtener un cliente por su nombre de usuario
    Optional<Cliente> getClienteByNombreUsuario(String nombreUsuario);

    // Guardar un nuevo cliente
    void saveCliente(Cliente cliente);

    // Eliminar un cliente por su ID
    void deleteCliente(Long id);
}
