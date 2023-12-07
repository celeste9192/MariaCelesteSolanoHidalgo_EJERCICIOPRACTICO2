/*
 * La interfaz ClienteDao extiende JpaRepository para realizar operaciones CRUD en la entidad Cliente.
 * Utiliza anotaciones como @Repository para indicar que es un componente de repositorio.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

    // Método personalizado para buscar un cliente por nombre de usuario
    Optional<Cliente> findByNombreUsuario(String nombreUsuario);
}
