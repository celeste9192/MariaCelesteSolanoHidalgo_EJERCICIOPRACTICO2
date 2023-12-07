/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.service;


import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.PreReserva;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Cliente;
import MariaCelesteSolanoHidalgo_EJERCICIOPRACTICO2.demo.domain.Vuelo;

import java.util.List;

public interface PreReservaService {

    List<PreReserva> getPrereservasByCliente(Cliente cliente);

    List<PreReserva> getPrereservasByVueloAndCliente(Vuelo vuelo, Cliente cliente);

    void savePrereserva(PreReserva prereserva);

    void deletePrereserva(Long id);
    
     List<PreReserva> getReservaById(Long id);
}
