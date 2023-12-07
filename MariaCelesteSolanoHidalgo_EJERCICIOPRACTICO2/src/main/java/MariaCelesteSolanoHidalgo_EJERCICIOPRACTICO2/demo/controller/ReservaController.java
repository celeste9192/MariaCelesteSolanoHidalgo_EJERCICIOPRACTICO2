/*
 * Este controlador maneja las operaciones relacionadas con la entidad Reserva en una aplicación Spring.
 * Utiliza anotaciones como @RestController y @RequestMapping para establecer la raíz de las URL relacionadas con reservas.
 * Se comunica con el servicio ReservaService para realizar operaciones en la base de datos.
 */

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Reserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    /*
     * Mapea la URL "/reservas" (GET) a la operación que obtiene todas las Reservas.
     * Llama al servicio de Reserva para obtener la lista de todas las reservas en la base de datos.
     */
    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    /*
     * Mapea la URL "/reservas" (POST) a la operación que crea una nueva Reserva.
     * Recibe un objeto Reserva desde el cuerpo de la solicitud y lo pasa al servicio de Reserva para ser guardado en la base de datos.
     * Devuelve una respuesta HTTP 200 (OK) en caso de éxito.
     */
    @PostMapping
    public ResponseEntity<Void> createReserva(@RequestBody Reserva reserva) {
        reservaService.saveReserva(reserva);
        return ResponseEntity.ok().build();
    }

    /*
     * Mapea la URL "/reservas/{id}" (DELETE) a la operación que elimina una Reserva por su ID.
     * Llama al servicio de Reserva para realizar la eliminación y devuelve una respuesta HTTP 200 (OK) en caso de éxito.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok().build();
    }
}
