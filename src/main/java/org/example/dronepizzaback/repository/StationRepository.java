package org.example.dronepizzaback.repository;

import org.example.dronepizzaback.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {

}
