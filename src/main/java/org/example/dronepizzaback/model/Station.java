package org.example.dronepizzaback.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double breddegrad;

    @Column(nullable = false)
    private double laengdegrad;

    @OneToMany(mappedBy = "station")
    private List<Drone> droner;

    public Station() {
    }

    public Station(double breddegrad, double laengdegrad) {
        this.breddegrad = breddegrad;
        this.laengdegrad = laengdegrad;
    }

    /* ---------- Getters and Setters ------------- */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBreddegrad() {
        return breddegrad;
    }

    public void setBreddegrad(double breddegrad) {
        this.breddegrad = breddegrad;
    }

    public double getLaengdegrad() {
        return laengdegrad;
    }

    public void setLaengdegrad(double laengdegrad) {
        this.laengdegrad = laengdegrad;
    }

    public List<Drone> getDroner() {
        return droner;
    }

    public void setDroner(List<Drone> droner) {
        this.droner = droner;
    }
}
