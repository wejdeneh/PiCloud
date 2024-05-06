package com.esprit.edusched.controllers;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.services.IReservationTService;
import com.esprit.edusched.services.ITerrainService;
import com.esprit.edusched.services.IUserService;
import com.esprit.edusched.services.ReservationTService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ReservationTController {
    @Autowired
    IReservationTService iReservationTService;
    @Autowired
    ITerrainService iTerrainService;
    @Autowired
    IUserService iUserService;
    @Autowired
    ReservationTService reservationTService;


    @PostMapping("/addReservationT")
    public ReservationT addReservationT(@RequestBody ReservationT resT){
        return iReservationTService.addReservationT(resT);
    }
    @PutMapping("/updateReservationT/{idResT}")
    public ReservationT updateReservationT(@PathVariable("idResT") int idResT,@RequestBody ReservationT resT) {

        ReservationT ExistingRes = iReservationTService.findReservationTById(idResT);
        if(ExistingRes==null){
            throw new EntityNotFoundException("Terrain Reservation not found with ID:"+idResT);
        }
        if(resT.getDate_debut()!=null){
        ExistingRes.setDate_debut(resT.getDate_debut());
        }else{
            ExistingRes.setDate_debut(ExistingRes.getDate_debut());
        }
        if(resT.getDate_fin()!=null){
        ExistingRes.setDate_fin(resT.getDate_fin());
        }else{
            ExistingRes.setDate_fin(ExistingRes.getDate_fin());
        }
        if(resT.getEtat()!=null){
        ExistingRes.setEtat(resT.getEtat());
        }else{
            ExistingRes.setEtat(ExistingRes.getEtat());
        }
        if(resT.getNbre()!=0){
            ExistingRes.setNbre(resT.getNbre());
        }else{
            ExistingRes.setNbre((ExistingRes.getNbre()));
        }
        if(resT.getTerrain()!=null){
        Terrain t = iTerrainService.findTerrainById(resT.getTerrain().getIdTerrain());
        if(t==null){
            throw new EntityNotFoundException("terrain not found with ID:"+resT.getTerrain().getIdTerrain());
        }
        ExistingRes.setTerrain(t);
        }else{
            ExistingRes.setTerrain(ExistingRes.getTerrain());
        }


        //reservationT.setUser(resT.getUser());*/

        return iReservationTService.updateReservationT(idResT,ExistingRes);

    }
    @DeleteMapping("/deleteReservationT/{idResT}")
    public void deleteReservationT(@PathVariable("idResT") int idResT){
         iReservationTService.deleteReservationT(idResT);
    }
    @GetMapping("/findAllReservationT")
    public List<ReservationT> findAllReservationT(){
        return iReservationTService.findAllReservationsT();
    }
    @GetMapping("/findReservationTById/{idResT}")
    public ReservationT findReservationTById(@PathVariable("idResT") int idresT){
        return iReservationTService.findReservationTById(idresT);
    }

    /*@PutMapping("/terrains/reserve/{idResT}")
    public ResponseEntity<String> reserve(@PathVariable int idResT,@PathVariable User user){
        reservationTService.reserver(idResT,user);
        return ResponseEntity.ok("Reservation successful");

    }*/
    @GetMapping("/reservations/available")
    public ResponseEntity<List<ReservationT>> getAvailableReservations(){
        List<ReservationT> availableReservations = reservationTService.getAvailableReservations();
        return ResponseEntity.ok(availableReservations);
    }

    @GetMapping("/terrains/reserve/{idUser}/{idResT}")
    public ResponseEntity<String> reserve(@PathVariable int idResT, @PathVariable int idUser){
        User user = iUserService.findUserById(idUser);
        boolean success = reservationTService.reserver(idResT,user);
        if(success){
            return ResponseEntity.ok("reservation successful");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
        }
    }

    @GetMapping("/reservationTs/{idUser}")
    public ResponseEntity<List<ReservationT>> getReservationsByIdUser(@PathVariable int idUser){
        User user = iUserService.findUserById(idUser);
        System.out.println(user);
        List<ReservationT> reservations = reservationTService.getReservationByUser(user);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/reservationTs/terrain/{idTerrain}")
    public ResponseEntity<List<ReservationT>> getReservationsByIdTerrain(@PathVariable int idTerrain){
        Terrain terrain = iTerrainService.findTerrainById(idTerrain);
        List<ReservationT> reservations = reservationTService.getReservationByTerrain(terrain);
        return ResponseEntity.ok(reservations);
    }

    /*@GetMapping("/timeline/terrain")
    Iterable<ReservationT> reservations(@RequestParam("from") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime from, @RequestParam("to") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime to){
        return  reservationTService.findBetween(from,to);
    }*/

    @GetMapping("/reservationT/between/{idResT}")
    public  List <Date> getDatesBetween(@PathVariable int idResT){
        ReservationT reservationT = reservationTService.findReservationTById(idResT);
        Date start = reservationT.getDate_debut();
        Date end = reservationT.getDate_fin();
        return getBetween(start,end);
    }

    private List<Date> getBetween(Date start, Date end){
        List <Date> datesBetween = new ArrayList<>();
        long interval = 24 * 1000 * 60 * 60;
        long endTime = end.getTime();
        long currentTime= start.getTime();
        while (currentTime <= endTime){
            datesBetween.add(new Date(currentTime));
            currentTime += interval;
        }
        return datesBetween;
    }








}
