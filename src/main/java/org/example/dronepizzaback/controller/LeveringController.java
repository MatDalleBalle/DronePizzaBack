package org.example.dronepizzaback.controller;

import org.example.dronepizzaback.model.Levering;
import org.example.dronepizzaback.service.LeveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
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
}
