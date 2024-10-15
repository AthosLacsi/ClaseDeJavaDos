package com.alacsi.pruebaJpa.controller;

import com.alacsi.pruebaJpa.model.Dulce;
import com.alacsi.pruebaJpa.repository.DulceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dulces")
public class DulceController {

    @Autowired
    private DulceRepository dulceRepository;

    // Obtener todos los dulces
    @GetMapping
    public List<Dulce> getAllDulces() {
        return dulceRepository.findAll();
    }

    // Obtener un dulce por ID
    @GetMapping("/{id}")
    public ResponseEntity<Dulce> getDulceById(@PathVariable Long id) {
        Optional<Dulce> dulce = dulceRepository.findById(id);
        return dulce.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo dulce
    @PostMapping
    public Dulce createDulce(@RequestBody Dulce dulce) {
        return dulceRepository.save(dulce);
    }

    // Actualizar un dulce
    @PutMapping("/{id}")
    public ResponseEntity<Dulce> updateDulce(@PathVariable Long id, @RequestBody Dulce dulceDetails) {
        Optional<Dulce> dulce = dulceRepository.findById(id);
        if (dulce.isPresent()) {
            Dulce updatedDulce = dulce.get();
            updatedDulce.setNombre(dulceDetails.getNombre());
            updatedDulce.setSabor(dulceDetails.getSabor());
            updatedDulce.setPrecio(dulceDetails.getPrecio());
            return ResponseEntity.ok(dulceRepository.save(updatedDulce));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un dulce
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDulce(@PathVariable Long id) {
        if (dulceRepository.existsById(id)) {
            dulceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



