package org.tareapsp.tareapsp2_1.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tareapsp.tareapsp2_1.modelo.entidad.Videojuego;

import java.util.List;


public interface DaoVideojuego extends JpaRepository<Videojuego, Long> {
    Videojuego findByNombre(String nombre);

    List<Videojuego> findByCompania(String compania);
}
