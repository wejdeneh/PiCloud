<<<<<<< HEAD
package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.ReservationC;
<<<<<<< HEAD
=======

package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.ReservationC;
import com.esprit.edusched.repositories.ReservationCRepository;
>>>>>>> origin/main
=======
import com.esprit.edusched.repositories.ReservationCRepository;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import com.esprit.edusched.services.ReservationCService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/reservationcs")

public class ReservationCController {
<<<<<<< HEAD
    @Autowired
    private ReservationCService reservationCService;
=======
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/reservationcs")

public class ReservationCController {
    private final ReservationCService reservationCService;
    private final ReservationCRepository reservationCRepository;

>>>>>>> origin/main
=======
    private final ReservationCService reservationCService;
    private final ReservationCRepository reservationCRepository;

>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    @PutMapping("/updatestatus/{id}")
    public ResponseEntity<ReservationC> updateReservationStatus(@PathVariable("id") Long id, @RequestBody Map<String, String> requestBody) {
        String newState = requestBody.get("state");
        if (newState != null && (newState.equals("confirmed") || newState.equals("unconfirmed"))) {
            ReservationC updatedReservationC = reservationCService.updateReservationState(id, newState);
            if (updatedReservationC != null) {
                return ResponseEntity.ok(updatedReservationC);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservationC(@PathVariable("id") Long id) {
        String result = reservationCService.deleteReservationC(id);
        if (result.equals("ReservationC deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    @PostMapping("/affect/{idC}")
  public  void addReservationAffectClass(@RequestBody ReservationC reservationC , @PathVariable Long idC  ){
         reservationCService.addReservationAffectClass(reservationC , idC);

    }



<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
}
