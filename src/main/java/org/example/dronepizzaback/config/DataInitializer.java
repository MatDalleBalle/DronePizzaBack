package org.example.dronepizzaback.config;

import org.example.dronepizzaback.model.Pizza;
import org.example.dronepizzaback.model.Station;
import org.example.dronepizzaback.repository.PizzaRepository;
import org.example.dronepizzaback.repository.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(StationRepository stationRepository, PizzaRepository pizzaRepository) {
        return args -> {
            // Tjekker, laver og gemmer stationer hvis ikke de eksisterer
            if (!stationRepository.existsById(1L)) {
                stationRepository.save(new Station(55.41, 12.34)); // Centrum af København
            }
            if (!stationRepository.existsById(2L)) {
                stationRepository.save(new Station(55.42, 12.35));
            }
            if (!stationRepository.existsById(3L)) {
                stationRepository.save(new Station(55.40, 12.33));
            }

            // Tjekker, laver og gemmer pizzaer hvis ikke de eksisterer
            if (!pizzaRepository.existsByTitel("Magherita")) {
                pizzaRepository.save(new Pizza("Magherita", 50));
            }
            if (!pizzaRepository.existsByTitel("Hawaii")) {
                pizzaRepository.save(new Pizza("Hawaii", 60));
            }
            if (!pizzaRepository.existsByTitel("Pepperoni")) {
                pizzaRepository.save(new Pizza("Pepperoni", 55));
            }
            if (!pizzaRepository.existsByTitel("Vesuvio")) {
                pizzaRepository.save(new Pizza("Vesuvio", 55));
            }
            if (!pizzaRepository.existsByTitel("Vegetar")) {
                pizzaRepository.save(new Pizza("Vegetar", 65));
            }
        };
    }
}
