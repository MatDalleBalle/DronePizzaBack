package org.example.dronepizzaback.repository;

import org.example.dronepizzaback.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository <Drone, Long>{

}
