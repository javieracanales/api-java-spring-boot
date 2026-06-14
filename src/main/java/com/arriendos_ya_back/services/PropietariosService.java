package com.arriendos_ya_back.services;

import com.arriendos_ya_back.models.propietario;
import com.arriendos_ya_back.repositories.PropietariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropietariosService {

    @Autowired
    private PropietariosRepository propietariosRepository;

    public List<propietario> listarTodos() {
        return propietariosRepository.findAll();
    }

    public Optional<propietario> buscarPorRut(String rut) {
        return propietariosRepository.findById(rut);
    }

    public propietario guardar(propietario propietario) {
        return propietariosRepository.save(propietario);
    }

    public void eliminar(String rut) {
        propietariosRepository.deleteById(rut);
    }
}