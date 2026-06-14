package com.arriendos_ya_back.repositories;

import com.arriendos_ya_back.models.arrendatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrendatariosRepository extends JpaRepository<arrendatario, String> {
}