package org.example.dronepizzaback.repository;


import org.example.dronepizzaback.model.Levering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeveringRepository extends JpaRepository <Levering, Long>{
    List<Levering> findByFaktiskLeveringsTidspunktIsNull();
    List<Levering> findByDroneIsNull();

}
