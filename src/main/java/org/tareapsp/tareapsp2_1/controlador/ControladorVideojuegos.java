package org.tareapsp.tareapsp2_1.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tareapsp.tareapsp2_1.modelo.entidad.Videojuego;
import org.tareapsp.tareapsp2_1.modelo.persistencia.DaoVideojuego;


import java.util.List;

@RestController
@RequestMapping("/videojuegos")
public class ControladorVideojuegos {

    @Autowired
    private DaoVideojuego daoVideojuego;

    @PostMapping("/crear")
    public ResponseEntity<Videojuego> create(@RequestBody Videojuego videojuego) {
        if (videojuego.getNombre() == null || videojuego.getNombre().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (daoVideojuego.findByNombre(videojuego.getNombre()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(daoVideojuego.save(videojuego), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> getById(@PathVariable Long id) {
        Videojuego videojuego = daoVideojuego.findById(id).orElse(null);
        if (videojuego == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(videojuego, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> update(@PathVariable Long id, @RequestBody Videojuego videojuego) {
        Videojuego existingVideojuego = daoVideojuego.findById(id).orElse(null);
        if (existingVideojuego == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingVideojuego.setNombre(videojuego.getNombre());
        existingVideojuego.setCompania(videojuego.getCompania());
        existingVideojuego.setNota(videojuego.getNota());
        return new ResponseEntity<>(daoVideojuego.save(existingVideojuego), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!daoVideojuego.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        daoVideojuego.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Videojuego>> getAll() {
        return new ResponseEntity<>(daoVideojuego.findAll(), HttpStatus.OK);
    }

    @GetMapping("/compania")
    public ResponseEntity<List<Videojuego>> getAllByCompania(@RequestParam String compania) {
        return new ResponseEntity<>(daoVideojuego.findByCompania(compania), HttpStatus.OK);
    }
}
