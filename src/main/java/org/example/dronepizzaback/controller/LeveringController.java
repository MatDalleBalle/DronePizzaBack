package org.example.dronepizzaback.controller;

import org.example.dronepizzaback.model.Levering;
import org.example.dronepizzaback.service.LeveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@CrossOrigin(origins = "http://localhost:63342")
public class LeveringController {

    @Autowired
    private LeveringService leveringService;

    @GetMapping
    public List<Levering> alleIkkeLeveredeLeveringer() {
        return leveringService.alleIkkeLeveredeLeveringer();
    }

    @PostMapping("/add")
    public Levering addLevering(@RequestParam Long pizzaId, @RequestParam String adresse) {
        return leveringService.addLevering(pizzaId, adresse);
    }

    @GetMapping("/queue")
    public List<Levering> findLeveringerUdenDrone() {
        return leveringService.findLeveringerUdenDrone();
    }

    @PutMapping("/schedule")
    public Levering scheduleLevering(@RequestParam Long leveringId, @RequestParam Long droneId) {
        return leveringService.scheduleLevering(leveringId, droneId);
    }

    @PutMapping("/finish")
    public Levering finishLevering(@RequestParam Long leveringId) {
        return leveringService.finishLevering(leveringId);
    }
}
