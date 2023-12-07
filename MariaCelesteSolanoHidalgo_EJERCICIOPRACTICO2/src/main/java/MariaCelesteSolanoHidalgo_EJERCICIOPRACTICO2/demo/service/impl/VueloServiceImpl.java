/*
 * Implementación de la interfaz VueloService que define operaciones relacionadas con la entidad Vuelo.
 * Se utiliza un objeto VueloDao para interactuar con la capa de persistencia.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.impl;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao.VueloDao;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImpl implements VueloService {

    private final VueloDao vueloDao;

    @Autowired
    public VueloServiceImpl(VueloDao vueloDao) {
        this.vueloDao = vueloDao;
    }

    // Obtener todos los vuelos
    @Override
    public List<Vuelo> getAllVuelos() {
        return vueloDao.findAll();
    }

    // Obtener un vuelo por su ID
    @Override
    public Optional<Vuelo> getVueloById(Long id) {
        return vueloDao.findById(id);
    }

    // Guardar un nuevo vuelo
    @Override
    public void saveVuelo(Vuelo vuelo) {
        vueloDao.save(vuelo);
    }

    // Eliminar un vuelo por su ID
    @Override
    public void deleteVuelo(Long id) {
        vueloDao.deleteById(id);
    }
}
