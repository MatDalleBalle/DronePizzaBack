package org.example.dronepizzaback.model;

import jakarta.persistence.*;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double breddegrad;

    @Column(nullable = false)
    private double laengdegrad;

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

    public double getLængdegrad() {
        return laengdegrad;
    }

    public void setLængdegrad(double laengdegrad) {
        this.laengdegrad = laengdegrad;
    }
}
