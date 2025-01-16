package org.example.dronepizzaback.service;

import org.example.dronepizzaback.model.Drone;
import org.example.dronepizzaback.model.Station;
import org.example.dronepizzaback.repository.DroneRepository;
import org.example.dronepizzaback.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private StationRepository stationRepository;

    public List<Drone> getAllDrones() {
    return droneRepository.findAll();
    }

    public Drone addDrone() {
        List<Station> stations = stationRepository.findAll();
        if (stations.isEmpty()) {
            throw new IllegalStateException("Ingen Stationer Tilgængelige");
        }
        Station stationMedMindstDroner = stations.stream()
                .min(Comparator.comparingInt(station -> station.getDroner().size()))
                .orElseThrow(() ->new IllegalStateException("Ingen Stationer Tilgængelige"));

        Drone nyDrone = new Drone(UUID.randomUUID(), Drone.Status.I_DRIFT, stationMedMindstDroner);
        return droneRepository.save(nyDrone);
    }
}
