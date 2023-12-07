package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.impl;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao.ClienteDao;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//imports necesario de la clase
@Service
class ClienteServiceImpl implements ClienteService {

    private final ClienteDao clienteDao;

    @Autowired
    public ClienteServiceImpl(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    // Método para obtener todos los clientes.
    @Override
    public List<Cliente> getAllClientes() {
        return clienteDao.findAll();
    }

    // Método para obtener un cliente por su ID.
    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteDao.findById(id);
    }

    // Método para obtener un cliente por su nombre de usuario.
    @Override
    public Optional<Cliente> getClienteByNombreUsuario(String nombreUsuario) {
        return clienteDao.findByNombreUsuario(nombreUsuario);
    }

    // Método para guardar un nuevo cliente.
    @Override
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    // Método para eliminar un cliente por su ID.
    @Override
    public void deleteCliente(Long id) {
        clienteDao.deleteById(id);
    }
}
