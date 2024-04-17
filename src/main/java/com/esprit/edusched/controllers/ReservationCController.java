package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.ReservationC;
import com.esprit.edusched.services.ReservationCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/reservationcs")
public class ReservationCController {
    @Autowired
    private ReservationCService reservationCService;

    @PostMapping("/add")
    public ResponseEntity<ReservationC> addReservationC(@RequestBody ReservationC reservationC) {
        return new ResponseEntity<>(reservationCService.addReservationC(reservationC), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationC>> getAllReservationCs() {
        List<ReservationC> reservationCs = reservationCService.getAllReservationCs();
        return ResponseEntity.ok(reservationCs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationC> getReservationCById(@PathVariable("id") Long id) {
        ReservationC reservationC = reservationCService.getReservationCById(id);
        if (reservationC != null) {
            return ResponseEntity.ok(reservationC);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReservationC> updateReservationC(@PathVariable("id") Long id, @RequestBody ReservationC reservationC) {
        ReservationC updatedReservationC = reservationCService.updateReservationC(id, reservationC);
        if (updatedReservationC != null) {
            return ResponseEntity.ok(updatedReservationC);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservationC(@PathVariable("id") Long id) {
        String result = reservationCService.deleteReservationC(id);
        if (result.equals("ReservationC deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
