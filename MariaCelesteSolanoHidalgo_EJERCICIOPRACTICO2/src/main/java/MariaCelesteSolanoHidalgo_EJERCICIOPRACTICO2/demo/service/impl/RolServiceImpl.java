

package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.impl;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao.RolDao;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Rol;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolDao rolDao;

    @Autowired
    public RolServiceImpl(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    // Obtener todos los roles
    @Override
    public List<Rol> getAllRoles() {
        return rolDao.findAll();
    }

    // Obtener un rol por su ID
    @Override
    public Optional<Rol> getRolById(Long id) {
        return rolDao.findById(id);
    }

    // Obtener un rol por su nombre
    @Override
    public Optional<Rol> getRolByNombre(String nombre) {
        return rolDao.findByNombre(nombre);
    }

    // Guardar un nuevo rol
    @Override
    public void saveRol(Rol rol) {
        rolDao.save(rol);
    }

    // Eliminar un rol por su ID
    @Override
    public void deleteRol(Long id) {
        rolDao.deleteById(id);
    }
}
