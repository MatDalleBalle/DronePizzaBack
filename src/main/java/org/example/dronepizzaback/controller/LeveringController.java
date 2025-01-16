package org.example.dronepizzaback.controller;

import org.example.dronepizzaback.model.Levering;
import org.example.dronepizzaback.service.LeveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
