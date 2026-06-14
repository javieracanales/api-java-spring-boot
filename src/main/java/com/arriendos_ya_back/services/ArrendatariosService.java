package com.arriendos_ya_back.services;

import com.arriendos_ya_back.models.arrendatario;
import com.arriendos_ya_back.repositories.ArrendatariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArrendatariosService {

    @Autowired
    private ArrendatariosRepository arrendatariosRepository;

    public List<arrendatario> listarTodos() {
        return arrendatariosRepository.findAll();
    }

    public Optional<arrendatario> buscarPorRut(String rut) {
        return arrendatariosRepository.findById(rut);
    }

    public arrendatario guardar(arrendatario arrendatario) {
        return arrendatariosRepository.save(arrendatario);
    }

    public void eliminar(String rut) {
        arrendatariosRepository.deleteById(rut);
    }
}