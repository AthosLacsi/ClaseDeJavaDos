package com.alacsi.pruebaJpa.service;

import com.alacsi.pruebaJpa.model.Dulce;
import com.alacsi.pruebaJpa.repository.DulceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DulceService {

    @Autowired
    private DulceRepository dulceRepository;

    public List<Dulce> findAll() {
        return dulceRepository.findAll();
    }

    public Dulce findById(Long id) {
        return dulceRepository.findById(id).orElseThrow(() -> new RuntimeException("Dulce no encontrado"));
    }

    public Dulce save(Dulce dulce) {
        return dulceRepository.save(dulce);
    }

    public Dulce update(Long id, Dulce dulceDetails) {
        Dulce dulce = findById(id);
        dulce.setNombre(dulceDetails.getNombre());
        dulce.setSabor(dulceDetails.getSabor());
        dulce.setPrecio(dulceDetails.getPrecio());
        return dulceRepository.save(dulce);
    }

    public void delete(Long id) {
        Dulce dulce = findById(id);
        dulceRepository.delete(dulce);
    }

    public List<Dulce> findDulcesMenosDeUnDolar() {
        return dulceRepository.findAll().stream()
                .filter(dulce -> dulce.getPrecio() < 1)
                .toList();
    }
}

