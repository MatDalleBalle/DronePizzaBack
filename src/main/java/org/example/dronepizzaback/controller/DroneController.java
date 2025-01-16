package org.example.dronepizzaback.controller;

import org.example.dronepizzaback.model.Drone;
import org.example.dronepizzaback.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
