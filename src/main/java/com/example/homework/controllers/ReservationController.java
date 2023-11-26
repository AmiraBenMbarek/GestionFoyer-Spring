package com.example.homework.controllers;

import com.example.homework.entities.Reservation;
import com.example.homework.services.IReservationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("reservation")
public class ReservationController {
    @Autowired
    IReservationService iReservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @GetMapping("/getReservations")
    public Iterable<Reservation> getReservations(){
        return iReservationService.getReservations();
    }

    @GetMapping("/getReservationById/{id}")
    public Reservation getReservationById(@PathVariable long id){
        return iReservationService.getReservationById(id);
    }

    @DeleteMapping("/deleteReservationById/{id}")
    public void deleteReservationById(@PathVariable long id){
        iReservationService.deleteReservation(id);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return iReservationService.updateReservation(r);
    }
}
