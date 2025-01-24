package org.example.dronepizzaback.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID serieNummer;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "station_id")
    @JsonBackReference
    private Station station;

    @OneToMany(mappedBy = "drone")
    @JsonBackReference
    private List<Levering> leveringer;

    public enum Status {
        I_DRIFT,
        UDE_AF_DRIFT,
        UDFASET
    }

    public Drone() {
    }

    public Drone(UUID serialNumber, Status status, Station station) {
        this.serieNummer = serialNumber;
        this.status = status;
        this.station = station;
    }

    /* ---------- Getters and Setters ------------- */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getSerieNummer() {
        return serieNummer;
    }

    public void setSerieNummer(UUID serialNumber) {
        this.serieNummer = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Levering> getLeveringer() {
        return leveringer;
    }

    public void setLeveringer(List<Levering> leveringer) {
        this.leveringer = leveringer;
    }
}
