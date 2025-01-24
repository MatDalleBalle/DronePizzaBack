package org.example.dronepizzaback.model;

import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Levering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private LocalDateTime forventetLeveringsTidspunkt;

    private LocalDateTime faktiskLeveringsTidspunkt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status {
        IKKE_LEVERET,
        I_GANG,
        FAERDIG
    }

    public Levering() {
    }

    public Levering(Drone drone, Pizza pizza, String adresse, LocalDateTime forventetLeveringsTidspunkt) {
        this.drone = drone;
        this.pizza = pizza;
        this.adresse = adresse;
        this.forventetLeveringsTidspunkt = forventetLeveringsTidspunkt;
    }

    /* ---------- Getters and Setters ------------- */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDateTime getForventetLeveringsTidspunkt() {
        return forventetLeveringsTidspunkt;
    }

    public void setForventetLeveringsTidspunkt(LocalDateTime forventetLeveringsTidspunkt) {
        this.forventetLeveringsTidspunkt = forventetLeveringsTidspunkt;
    }

    public LocalDateTime getFaktiskLeveringsTidspunkt() {
        return faktiskLeveringsTidspunkt;
    }

    public void setFaktiskLeveringsTidspunkt(LocalDateTime faktiskLeveringsTidspunkt) {
        this.faktiskLeveringsTidspunkt = faktiskLeveringsTidspunkt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

