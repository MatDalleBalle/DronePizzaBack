package org.example.dronepizzaback.service;

import org.example.dronepizzaback.model.Levering;
import org.example.dronepizzaback.repository.LeveringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeveringService {

    @Autowired
    private LeveringRepository leveringRepository;

    public List<Levering> alleIkkeLeveredeLeveringer() {
        return leveringRepository.findByFaktiskLeveringsTidspunktIsNull();
    }
}
