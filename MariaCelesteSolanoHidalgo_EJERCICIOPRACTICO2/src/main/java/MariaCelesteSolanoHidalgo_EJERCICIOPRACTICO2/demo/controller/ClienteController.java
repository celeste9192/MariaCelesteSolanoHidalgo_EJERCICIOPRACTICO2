/*
 * Este controlador maneja las operaciones relacionadas con la entidad Cliente en una aplicación Spring.
 * Utiliza anotaciones como @Controller para indicar que es un controlador y @RequestMapping para establecer
 * la raíz de las URL relacionadas con clientes.
 * Se comunica con la capa de servicio (ClienteService) para realizar operaciones en la base de datos.
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.controller;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /*
     * Mapea la URL "/clientes/list" a la operación que lista todos los clientes.
     * Recupera la lista de clientes desde la capa de servicio y la agrega al modelo para su visualización.
     * Devuelve la vista "cliente/list" que muestra la lista de clientes.
     */
    @GetMapping("/list")
    public String listClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "cliente/list";
    }

    /*
     * Mapea la URL "/clientes/show/{id}" a la operación que muestra los detalles de un cliente específico.
     * Recupera el cliente por su ID desde la capa de servicio y lo agrega al modelo para su visualización.
     * Devuelve la vista "cliente/show" que muestra los detalles del cliente.
     * En caso de que el cliente no exista, redirige a la lista de clientes.
     */
    @GetMapping("/show/{id}")
    public String showCliente(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente/show";
        } else {
            // Manejar el caso en que el cliente no exista
            return "redirect:/clientes/list";
        }
    }

    /*
     * Mapea la URL "/clientes/add" a la operación que muestra el formulario para agregar un nuevo cliente.
     * Crea un nuevo objeto Cliente y lo agrega al modelo para ser utilizado en el formulario.
     * Devuelve la vista "cliente/add" que contiene el formulario de adición de clientes.
     */
    @GetMapping("/add")
    public String addClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/add";
    }

    /*
     * Mapea la URL "/clientes/add" (POST) a la operación que procesa la adición de un nuevo cliente.
     * Recibe un objeto Cliente desde el formulario y lo pasa a la capa de servicio para ser guardado en la base de datos.
     * Luego, redirige a la lista de clientes.
     */
    @PostMapping("/add")
    public String addCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes/list";
    }

    /*
     * Mapea la URL "/clientes/edit/{id}" a la operación que muestra el formulario para editar un cliente existente.
     * Recupera el cliente por su ID desde la capa de servicio y lo agrega al modelo para su visualización en el formulario.
     * Devuelve la vista "cliente/edit" que contiene el formulario de edición de clientes.
     * En caso de que el cliente no exista, redirige a la lista de clientes.
     */
    @GetMapping("/edit/{id}")
    public String editClienteForm(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente/edit";
        } else {
            // Manejar el caso en que el cliente no exista
            return "redirect:/clientes/list";
        }
    }

    /*
     * Mapea la URL "/clientes/edit/{id}" (POST) a la operación que procesa la edición de un cliente existente.
     * Recibe un objeto Cliente desde el formulario, establece su ID y lo pasa a la capa de servicio para ser actualizado.
     * Luego, redirige a la lista de clientes.
     */
    @PostMapping("/edit/{id}")
    public String editCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.saveCliente(cliente);
        return "redirect:/clientes/list";
    }

    /*
     * Mapea la URL "/clientes/delete/{id}" a la operación que elimina un cliente por su ID.
     * Luego, redirige a la lista de clientes.
     */
    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes/list";
    }
}
