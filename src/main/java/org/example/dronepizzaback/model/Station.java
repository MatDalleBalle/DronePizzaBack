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
    private double længdegrad;


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
        return længdegrad;
    }

    public void setLængdegrad(double længdegrad) {
        this.længdegrad = længdegrad;
    }
}
