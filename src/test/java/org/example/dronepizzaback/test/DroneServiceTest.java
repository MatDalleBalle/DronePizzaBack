package org.example.dronepizzaback.test;

import org.example.dronepizzaback.model.Drone;
import org.example.dronepizzaback.model.Station;
import org.example.dronepizzaback.repository.DroneRepository;
import org.example.dronepizzaback.repository.StationRepository;
import org.example.dronepizzaback.service.DroneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DroneServiceTest {

    @Mock
    private DroneRepository droneRepository;

    @Mock
    private StationRepository stationRepository;

    @InjectMocks
    private DroneService droneService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDrone() {
        Station station = new Station();
        station.setDroner(Collections.emptyList());
        when(stationRepository.findAll()).thenReturn(Collections.singletonList(station));
        when(droneRepository.save(any(Drone.class))).thenAnswer(i -> i.getArguments()[0]);

        Drone drone = droneService.addDrone();

        assertNotNull(drone);
        assertEquals(Drone.Status.I_DRIFT, drone.getStatus());
        assertEquals(station, drone.getStation());
        verify(droneRepository, times(1)).save(any(Drone.class));
    }

    @Test
    public void testUpdateDroneStatus_DroneNotFound() {
        Long droneId = 1L;
        when(droneRepository.findById(droneId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalStateException.class, () -> {
                droneService.opdaterDroneStatus(droneId, Drone.Status.I_DRIFT);
    });

    assertEquals("Drone med id " + droneId + " findes ikke", exception.getMessage());
    }

    @Test
    public void testUpdateDroneStatus() {
        Long droneId = 1L;
        Drone drone = new Drone(UUID.randomUUID(), Drone.Status.I_DRIFT, new Station());
        when(droneRepository.findById(droneId)).thenReturn(Optional.of(drone));
        when(droneRepository.save(any(Drone.class))).thenAnswer(i -> i.getArguments()[0]);

        Drone updatedDrone = droneService.opdaterDroneStatus(droneId, Drone.Status.UDE_AF_DRIFT);

        assertNotNull(updatedDrone);
        assertEquals(Drone.Status.UDE_AF_DRIFT, updatedDrone.getStatus());
        verify(droneRepository, times(1)).save(any(Drone.class));
    }

    @Test
    public void testAddDrone_NoStationAvailable() {
    when(stationRepository.findAll()).thenReturn(Collections.emptyList());

    Exception exception = assertThrows(IllegalStateException.class, () -> {
        droneService.addDrone();
    });

    assertEquals("Ingen Stationer Tilgængelige", exception.getMessage());
    }
}
