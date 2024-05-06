package com.esprit.edusched.controllers;



import com.esprit.edusched.entities.Material;
import com.esprit.edusched.entities.ReservationM;
import com.esprit.edusched.services.IMaterialService;
import com.esprit.edusched.services.IReservationMService;
import com.esprit.edusched.services.TwilioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ReservationMController {
    @Autowired
    IReservationMService iReservationMService;
    IMaterialService iMaterialService;
    private final TwilioService twilioService;

    @PostMapping("/addReservationM/{idMaterial}")
    public ReservationM addReservationM(@PathVariable("idMaterial") int idMaterial, @RequestBody ReservationM resM){
        ReservationM reservationM = new ReservationM();
        reservationM.setDate_debut(resM.getDate_debut());
        reservationM.setDate_fin(resM.getDate_fin());
        reservationM.setEtat(resM.getEtat());

        Material m = iMaterialService.findMaterialById(idMaterial);
        if(m==null){
            throw new EntityNotFoundException("Material not found with ID:"+resM.getMaterial().getIdMaterial());
        }
        /**
        reservationM.setMaterial(m);
        //reservationM.setUser(resM.getUser());
        // create mailing and sms
        // Customize the message according to your requirements
        String message = "A new Reservation has been added: " + reservationM;

        // Replace phoneNumber with the actual phone number where you want to send the notification
        // DONT FORGET TO VERIFY ON Twilio !!!!!!
        String phoneNumber = "+21698340515";

        // Send SMS notification using TwilioService
        twilioService.sendSms(phoneNumber, message);
            **/
        return iReservationMService.addReservationM(reservationM);
    }

    @PutMapping("/updateReservationM/{idResM}")
    public ReservationM updateReservationM(@PathVariable("idResM") int idResM,@RequestBody ReservationM resM){
        ReservationM ExistingRes = iReservationMService.findReservationMById(idResM);
        if(ExistingRes==null){
            throw new EntityNotFoundException("Material Reservation not found with ID:"+idResM);
        }
        if(resM.getDate_debut()!=null){
            ExistingRes.setDate_debut(resM.getDate_debut());
        }else{
            ExistingRes.setDate_debut(ExistingRes.getDate_debut());
        }
        if(resM.getDate_fin()!=null){
            ExistingRes.setDate_fin(resM.getDate_fin());
        }else{
            ExistingRes.setDate_fin(ExistingRes.getDate_fin());
        }
        if(resM.getEtat()!=null){
            ExistingRes.setEtat(resM.getEtat());
        }else{
            ExistingRes.setEtat(ExistingRes.getEtat());
        }
        if(resM.getMaterial()!=null){
            Material m = iMaterialService.findMaterialById(resM.getMaterial().getIdMaterial());
            if(m==null){
                throw new EntityNotFoundException("terrain not found with ID:"+resM.getMaterial().getIdMaterial());
            }
            ExistingRes.setMaterial(m);
        }else{
            ExistingRes.setMaterial(ExistingRes.getMaterial());
        }
        //reservationM.setUser(resM.getUser());
        return iReservationMService.updateReservationM(idResM,ExistingRes);
    }
    @DeleteMapping("/deleteReservationM/{idResM}")
    public void deleteReservationM(@PathVariable("idResM") int idResM){
        iReservationMService.deleteReservationM(idResM);
    }
    @GetMapping("/findAllReservationM")
    public List<ReservationM> findAllReservationM(){
        return iReservationMService.findAllReservationsM();
    }
    @GetMapping("/findReservationMById/{idResM}")
    public ReservationM findReservationMById(@PathVariable("idResM") int idResM){
        return iReservationMService.findReservationMById(idResM);
    }

}
