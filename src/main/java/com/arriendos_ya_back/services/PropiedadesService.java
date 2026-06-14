package com.arriendos_ya_back.services;

import com.arriendos_ya_back.models.propiedad;
import com.arriendos_ya_back.repositories.PropiedadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropiedadesService {

    @Autowired
    private PropiedadesRepository propiedadesRepository;

    public List<propiedad> listarPropiedades() {
        return propiedadesRepository.findAll();
    }

    public Optional<propiedad> buscarPropiedadesPorId(Long id) {
        return propiedadesRepository.findById(id);
    }

    public propiedad guardarPropiedades(propiedad propiedad) {
        return propiedadesRepository.save(propiedad);
    }

    public void eliminarPropiedades(Long id) {
        propiedadesRepository.deleteById(id);
    }
}