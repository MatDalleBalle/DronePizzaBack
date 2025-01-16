package org.example.dronepizzaback.service;

import org.example.dronepizzaback.model.Drone;
import org.example.dronepizzaback.model.Levering;
import org.example.dronepizzaback.model.Pizza;
import org.example.dronepizzaback.model.Levering.Status;
import org.example.dronepizzaback.repository.DroneRepository;
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
    @Autowired
    private DroneRepository droneRepository;

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
        levering.setStatus(Status.IKKE_LEVERET);
        return leveringRepository.save(levering);
    }

    public List<Levering> findLeveringerUdenDrone() {
        return leveringRepository.findByDroneIsNull();
    }

    public Levering scheduleLevering(Long leveringId, Long droneId) {
        Levering levering = leveringRepository.findById(leveringId)
                .orElseThrow(() -> new IllegalStateException("Levering med id " + leveringId + " findes ikke"));

        if (levering.getDrone() != null) {
            throw new IllegalStateException("Levering er allerede i gang med at blive leveret");
        }

        Drone drone = droneRepository.findById(droneId)
                .orElseThrow(() -> new IllegalStateException("Drone med id " + droneId + " findes ikke"));

        if (drone.getStatus() != Drone.Status.I_DRIFT) {
            throw new IllegalStateException("Drone er ikke i drift");
        }

        levering.setDrone(drone);
        levering.setStatus(Status.I_GANG);
        return leveringRepository.save(levering);
    }

    public Levering finishLevering(Long leveringId) {
        Levering levering = leveringRepository.findById(leveringId)
                .orElseThrow(() -> new IllegalStateException("Levering med id " + leveringId + " findes ikke"));

        if (levering.getDrone() == null) {
            throw new IllegalStateException("Levering har ingen tilknyttet drone");
    }
    levering.setStatus(Levering.Status.FAERDIG);
    levering.setFaktiskLeveringsTidspunkt(LocalDateTime.now());
    return leveringRepository.save(levering);
    }

}
