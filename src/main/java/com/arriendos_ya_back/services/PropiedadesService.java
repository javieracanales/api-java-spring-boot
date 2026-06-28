package com.arriendos_ya_back.services;

import com.arriendos_ya_back.models.arrendatario;
import com.arriendos_ya_back.models.propiedad;
import com.arriendos_ya_back.repositories.PropiedadesRepository;
import com.arriendos_ya_back.repositories.ArrendatariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropiedadesService {

    @Autowired
    private PropiedadesRepository propiedadesRepository;

    @Autowired
    private ArrendatariosRepository arrendatariosRepository;

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

    public Optional<propiedad> asignarArrendatario(Long propiedadId, String arrendatarioRut) {
        String rutLimpio = arrendatarioRut.trim().toUpperCase(); // Forzamos mayúscula automática

        Optional<propiedad> propiedadOpt = propiedadesRepository.findById(propiedadId);
        Optional<arrendatario> arrendatarioOpt = arrendatariosRepository.findById(rutLimpio);

        if (propiedadOpt.isPresent() && arrendatarioOpt.isPresent()) {
            propiedad propiedadReal = propiedadOpt.get();
            propiedadReal.setArrendatario(arrendatarioOpt.get());
            return Optional.of(propiedadesRepository.save(propiedadReal));
        }
        return Optional.empty();
    }
    
}