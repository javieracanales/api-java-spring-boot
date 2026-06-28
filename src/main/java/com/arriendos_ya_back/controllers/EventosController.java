package com.arriendos_ya_back.controllers;

import com.arriendos_ya_back.models.evento;
import com.arriendos_ya_back.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    // GET http://localhost:3000/api/eventos
    @GetMapping
    public List<evento> obtenerTodos() {
        return eventosService.listarTodos();
    }

    // POST http://localhost:3000/api/eventos
    @PostMapping
    public ResponseEntity<evento> crear(@RequestBody evento nuevoEvento) {
        Optional<evento> eventoGuardado = eventosService.guardar(nuevoEvento);

        if (eventoGuardado.isPresent()) {
            return ResponseEntity.ok(eventoGuardado.get());
        } else {
            return ResponseEntity.badRequest().build(); 
        }
    }

    // GET http://localhost:3000/api/eventos/propiedad/{propiedadId}
    @GetMapping("/propiedad/{propiedadId}")
    public ResponseEntity<List<evento>> obtenerHistorialPorPropiedad(@PathVariable Long propiedadId) {
        List<evento> historial = eventosService.obtenerHistorialPorPropiedad(propiedadId);
        return ResponseEntity.ok(historial);
}
}