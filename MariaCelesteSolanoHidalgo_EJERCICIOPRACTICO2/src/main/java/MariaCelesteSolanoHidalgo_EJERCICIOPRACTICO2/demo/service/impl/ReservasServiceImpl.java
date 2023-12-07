package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.impl;

import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.dao.ReservaDao;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Reserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasServiceImpl implements ReservaService {

    private final ReservaDao reservaDao;

    @Autowired
    public ReservasServiceImpl(ReservaDao reservaDao) {
        this.reservaDao = reservaDao;
    }

    // Obtener todas las reservas asociadas a un cliente
    @Override
    public List<Reserva> getReservasByCliente(Cliente cliente) {
        return reservaDao.findByCliente(cliente);
    }

    // Obtener reservas asociadas a un vuelo y un cliente específico
    @Override
    public List<Reserva> getReservasByVueloAndCliente(Vuelo vuelo, Cliente cliente) {
        return reservaDao.findByVueloAndCliente(vuelo, cliente);
    }

    // Guardar una nueva reserva
    @Override
    public void saveReserva(Reserva reserva) {
        reservaDao.save(reserva);
    }

    // Eliminar una reserva por su ID
    @Override
    public void deleteReserva(Long id) {
        reservaDao.deleteById(id);
    }

    // Obtener todas las reservas
    @Override
    public List<Reserva> getAllReservas() {
        return reservaDao.findAll();
    }

    // Obtener una reserva por su ID (no implementado todavía)
    @Override
    public Optional<Reserva> getReservaById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Mensaje temporal hasta que se implemente
    }
}
