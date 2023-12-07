/*
 * Este controlador maneja las operaciones relacionadas con la entidad Rol en una aplicación Spring.
 * Utiliza anotaciones como @RestController y @RequestMapping para establecer la raíz de las URL relacionadas con roles.
 * Se comunica con el servicio RolService para realizar operaciones en la base de datos.
 */

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Rol;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    /*
     * Mapea la URL "/roles" (GET) a la operación que obtiene todos los Roles.
     * Llama al servicio de Rol para obtener la lista de todos los roles en la base de datos.
     */
    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    /*
     * Mapea la URL "/roles/{id}" (GET) a la operación que obtiene un Rol por su ID.
     * Llama al servicio de Rol para obtener el rol con el ID proporcionado.
     * Devuelve una respuesta HTTP 200 (OK) con el rol si se encuentra, o una respuesta HTTP 404 (Not Found) si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        return rolService.getRolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * Mapea la URL "/roles" (POST) a la operación que crea un nuevo Rol.
     * Recibe un objeto Rol desde el cuerpo de la solicitud y lo pasa al servicio de Rol para ser guardado en la base de datos.
     * Devuelve una respuesta HTTP 200 (OK) en caso de éxito.
     */
    @PostMapping
    public ResponseEntity<Void> createRol(@RequestBody Rol rol) {
        rolService.saveRol(rol);
        return ResponseEntity.ok().build();
    }

    /*
     * Mapea la URL "/roles/{id}" (PUT) a la operación que actualiza un Rol existente.
     * Recibe un objeto Rol desde el cuerpo de la solicitud y lo pasa al servicio de Rol para ser actualizado en la base de datos.
     * Devuelve una respuesta HTTP 200 (OK) si la actualización es exitosa, o una respuesta HTTP 404 (Not Found) si el rol no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        return rolService.getRolById(id)
                .map(existingRol -> {
                    rol.setId(id);
                    rolService.saveRol(rol);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
