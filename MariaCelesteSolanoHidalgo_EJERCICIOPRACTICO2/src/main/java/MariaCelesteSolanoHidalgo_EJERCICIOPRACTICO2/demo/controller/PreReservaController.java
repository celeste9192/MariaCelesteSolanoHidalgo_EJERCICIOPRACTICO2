/*
 * Este controlador maneja las operaciones relacionadas con la entidad PreReserva en una aplicación Spring.
 * Utiliza anotaciones como @RestController y @RequestMapping para establecer la raíz de las URL relacionadas con prereservas.
 * Se comunica con las capas de servicio (PreReservaService, VueloService, ClienteService) para realizar operaciones en la base de datos.
 */

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.PreReserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.VueloService;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.ClienteService;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.PreReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prereservas")
public class PreReservaController {

    private final PreReservaService prereservaService;
    private final VueloService vueloService;
    private final ClienteService clienteService;

    @Autowired
    public PreReservaController(PreReservaService prereservaService, VueloService vueloService, ClienteService clienteService) {
        this.prereservaService = prereservaService;
        this.vueloService = vueloService;
        this.clienteService = clienteService;
    }

    /*
     * Mapea la URL "/prereservas/vuelo/{vueloId}/cliente/{clienteId}" a la operación que obtiene las PreReservas
     * asociadas a un Vuelo y un Cliente específicos.
     * Recibe los IDs del vuelo y del cliente desde la URL.
     * Luego, llama a los servicios correspondientes para obtener el Vuelo y el Cliente.
     * Finalmente, llama al servicio de PreReserva para obtener las PreReservas asociadas al Vuelo y al Cliente.
     */
    @GetMapping("/vuelo/{vueloId}/cliente/{clienteId}")
    public List<PreReserva> getPrereservasByVueloAndCliente(@PathVariable Long vueloId, @PathVariable Long clienteId) {
        // Obtener el vuelo por su ID
        Vuelo vuelo = vueloService.getVueloById(vueloId)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado con ID: " + vueloId));

        // Obtener el cliente por su ID
        Cliente cliente = clienteService.getClienteById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + clienteId));

        // Llamar al servicio para obtener las Prereservas por vuelo y cliente
        return prereservaService.getPrereservasByVueloAndCliente(vuelo, cliente);
    }

    /*
     * Mapea la URL "/prereservas" (POST) a la operación que crea una nueva PreReserva.
     * Recibe un objeto PreReserva desde el cuerpo de la solicitud y lo pasa al servicio de PreReserva para ser guardado en la base de datos.
     * Devuelve una respuesta HTTP 200 (OK) en caso de éxito.
     */
    @PostMapping
    public ResponseEntity<Void> createPrereserva(@RequestBody PreReserva prereserva) {
        prereservaService.savePrereserva(prereserva);
        return ResponseEntity.ok().build();
    }

    /*
     * Mapea la URL "/prereservas/{id}" (DELETE) a la operación que elimina una PreReserva por su ID.
     * Llama al servicio de PreReserva para realizar la eliminación y devuelve una respuesta HTTP 200 (OK) en caso de éxito.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrereserva(@PathVariable Long id) {
        prereservaService.deletePrereserva(id);
        return ResponseEntity.ok().build();
    }
}
