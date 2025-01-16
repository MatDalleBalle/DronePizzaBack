package org.example.dronepizzaback.service;

import org.example.dronepizzaback.model.Levering;
import org.example.dronepizzaback.model.Pizza;
import org.example.dronepizzaback.repository.LeveringRepository;
import org.example.dronepizzaback.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeveringService {

    @Autowired
    private LeveringRepository leveringRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Levering> alleIkkeLeveredeLeveringer() {
        return leveringRepository.findByFaktiskLeveringsTidspunktIsNull();
    }

    public Levering addLevering(Long pizzaId, String adresse) {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new IllegalStateException("Pizza med id " + pizzaId + " findes ikke"));

        Levering levering = new Levering();
        levering.setPizza(pizza);
        levering.setAdresse(adresse);
        /* Sætter den forventede leveringstid til 30 minutter fra nu */
        levering.setForventetLeveringsTidspunkt(LocalDateTime.now().plusMinutes(30));
        return leveringRepository.save(levering);
    }

    public List<Levering> findLeveringerUdenDrone() {
        return leveringRepository.findByDroneIsNull();
    }
}
