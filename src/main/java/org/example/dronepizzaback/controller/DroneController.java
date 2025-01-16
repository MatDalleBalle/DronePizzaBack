package org.example.dronepizzaback.controller;

import org.example.dronepizzaback.model.Drone;
import org.example.dronepizzaback.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping
    public List<Drone> getDrones() {
        return droneService.getAllDrones();
    }

    @PostMapping("/add")
    public Drone addDrone() {
        return droneService.addDrone();
    }

    @PutMapping("/enable/{id}")
    public Drone enableDrone(@PathVariable Long id) {
        return droneService.opdaterDroneStatus(id, Drone.Status.I_DRIFT);
    }
    @PutMapping("/disable/{id}")
    public Drone disableDrone(@PathVariable Long id) {
        return droneService.opdaterDroneStatus(id, Drone.Status.UDE_AF_DRIFT);
    }

    @PutMapping("/retire/{id}")
    public Drone retireDrone(@PathVariable Long id) {
        return droneService.opdaterDroneStatus(id, Drone.Status.UDFASET);
    }


}
