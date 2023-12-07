/*
 * Este controlador maneja las operaciones relacionadas con la entidad Vuelo en una aplicación Spring.
 * Utiliza anotaciones como @RestController y @RequestMapping para establecer la raíz de las URL relacionadas con vuelos.
 * Se comunica con el servicio VueloService para realizar operaciones en la base de datos.
 */

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    /*
     * Mapea la URL "/vuelos" (GET) a la operación que obtiene todos los Vuelos.
     * Llama al servicio de Vuelo para obtener la lista de todos los vuelos en la base de datos.
     */
    @GetMapping
    public List<Vuelo> getAllVuelos() {
        return vueloService.getAllVuelos();
    }

    /*
     * Mapea la URL "/vuelos/{id}" (GET) a la operación que obtiene un Vuelo por su ID.
     * Llama al servicio de Vuelo para obtener el vuelo con el ID proporcionado.
     * Devuelve una respuesta HTTP 200 (OK) con el vuelo si se encuentra, o una respuesta HTTP 404 (Not Found) si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> getVueloById(@PathVariable Long id) {
        return vueloService.getVueloById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * Mapea la URL "/vuelos" (POST) a la operación que crea un nuevo Vuelo.
     * Recibe un objeto Vuelo desde el cuerpo de la solicitud y lo pasa al servicio de Vuelo para ser guardado en la base de datos.
     * Devuelve una respuesta HTTP 200 (OK) en caso de éxito.
     */
    @PostMapping
    public ResponseEntity<Void> createVuelo(@RequestBody Vuelo vuelo) {
        vueloService.saveVuelo(vuelo);
        return ResponseEntity.ok().build();
    }

    /*
     * Mapea la URL "/vuelos/{id}" (PUT) a la operación que actualiza un Vuelo existente.
     * Recibe un objeto Vuelo desde el cuerpo de la solicitud y lo pasa al servicio de Vuelo para ser actualizado en la base de datos.
     * Devuelve una respuesta HTTP 200 (OK) si la actualización es exitosa, o una respuesta HTTP 404 (Not Found) si el vuelo no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        if (vueloService.getVueloById(id).isPresent()) {
            vuelo.setId(id);
            vueloService.saveVuelo(vuelo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
     * Mapea la URL "/vuelos/{id}" (DELETE) a la operación que elimina un Vuelo por su ID.
     * Llama al servicio de Vuelo para eliminar el vuelo con el ID proporcionado.
     * Devuelve una respuesta HTTP 200 (OK) si la eliminación es exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
        vueloService.deleteVuelo(id);
        return ResponseEntity.ok().build();
    }
}
