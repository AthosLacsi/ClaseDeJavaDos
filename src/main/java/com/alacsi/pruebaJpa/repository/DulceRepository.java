package com.alacsi.pruebaJpa.repository;

import com.alacsi.pruebaJpa.model.Dulce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DulceRepository extends JpaRepository<Dulce, Long> {
}

