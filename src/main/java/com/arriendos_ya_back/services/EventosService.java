package com.arriendos_ya_back.services;

import com.arriendos_ya_back.models.evento;
import com.arriendos_ya_back.models.propiedad;
import com.arriendos_ya_back.repositories.EventosRepository;
import com.arriendos_ya_back.repositories.PropiedadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    @Autowired
    private PropiedadesRepository propiedadesRepository;

    public List<evento> listarTodos() {
        return eventosRepository.findAll();
    }

    public Optional<evento> guardar(evento evento) {
        if (evento.getPropiedad() != null && evento.getPropiedad().getId() != null) {
            Optional<propiedad> propiedadOpt = propiedadesRepository.findById(evento.getPropiedad().getId());
            
            if (propiedadOpt.isPresent()) {
                evento.setPropiedad(propiedadOpt.get()); 
            } else {
                return Optional.empty(); 
            }
        }
        if (evento.getFecha() == null) {
            evento.setFecha(ZonedDateTime.now());
        }

        return Optional.of(eventosRepository.save(evento));
    }

    public List<evento> obtenerHistorialPorPropiedad(Long propiedadId) {
    return eventosRepository.findByPropiedadId(propiedadId);
}
}