/*
 * La interfaz RolDao extiende JpaRepository para realizar operaciones CRUD en la entidad Rol.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolDao extends JpaRepository<Rol, Long> {

    // Método para buscar un rol por nombre
    Optional<Rol> findByNombre(String nombre);

}
