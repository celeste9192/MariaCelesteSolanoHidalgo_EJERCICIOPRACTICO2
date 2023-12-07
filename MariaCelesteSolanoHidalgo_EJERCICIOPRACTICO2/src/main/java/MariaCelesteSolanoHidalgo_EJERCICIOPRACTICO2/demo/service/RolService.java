/*
 * La interfaz RolService define los métodos que deben ser implementados por las clases que proporcionan servicios relacionados con los roles.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {

    // Obtener todos los roles
    List<Rol> getAllRoles();

    // Obtener un rol por su ID
    Optional<Rol> getRolById(Long id);

    // Obtener un rol por su nombre
    Optional<Rol> getRolByNombre(String nombre);

    // Guardar un nuevo rol
    void saveRol(Rol rol);

    // Eliminar un rol por su ID
    void deleteRol(Long id);
}
