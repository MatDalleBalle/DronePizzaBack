package org.example.dronepizzaback.repository;

import org.example.dronepizzaback.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    boolean existsByTitel(String titel);
}
