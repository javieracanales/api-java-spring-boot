package com.arriendos_ya_back.repositories;

import com.arriendos_ya_back.models.evento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<evento, Long> {
    List<evento> findByPropiedadId(Long propiedadId);
}