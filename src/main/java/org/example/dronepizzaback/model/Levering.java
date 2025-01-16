package org.example.dronepizzaback.model;

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
    private LocalDateTime forventetLeveringstidsPunkt;

    private LocalDateTime faktiskLeveringstidsPunkt;

    public Levering() {
    }

    public Levering(Drone drone, Pizza pizza, String adresse, LocalDateTime forventetLeveringstidsPunkt) {
        this.drone = drone;
        this.pizza = pizza;
        this.adresse = adresse;
        this.forventetLeveringstidsPunkt = forventetLeveringstidsPunkt;
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

    public LocalDateTime getForventetLeveringstidsPunkt() {
        return forventetLeveringstidsPunkt;
    }

    public void setForventetLeveringstidsPunkt(LocalDateTime forventetLeveringstidsPunkt) {
        this.forventetLeveringstidsPunkt = forventetLeveringstidsPunkt;
    }

    public LocalDateTime getFaktiskLeveringstidsPunkt() {
        return faktiskLeveringstidsPunkt;
    }

    public void setFaktiskLeveringstidsPunkt(LocalDateTime faktiskLeveringstidsPunkt) {
        this.faktiskLeveringstidsPunkt = faktiskLeveringstidsPunkt;
    }
}
