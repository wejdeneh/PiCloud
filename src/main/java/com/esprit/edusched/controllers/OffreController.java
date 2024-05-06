package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.FrontDTO;
import com.esprit.edusched.dto.OffreDTO;
import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.OffreEtat;
import com.esprit.edusched.entities.Reservation;
import com.esprit.edusched.entities.ReservationResponse;
import com.esprit.edusched.repositories.OffreRepository;
import com.esprit.edusched.services.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/offres")
public class OffreController {
    @Autowired
    private OffreService offreService;

    @Autowired
    private OffreRepository offreRepository;

    //@PostMapping
  /* @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Offre> createOffre(@RequestBody Offre offre) {
        return new ResponseEntity<>(offreService.addOffre(offre), HttpStatus.OK);
    }*/

    public static String UPLOAD_DIRECTORY = "D:/pi/angular-crud-app-main - Copie (3)/src/assets/";

    //@PostMapping
    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Offre> createOffre(@RequestBody Offre offre) {
        offre.setEtat(OffreEtat.NON_ARCHIVE);
        return new ResponseEntity<>(offreService.addOffre(offre), HttpStatus.OK);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String fileName = currentDate + "_" + file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
        Files.write(path, bytes);
        return fileName;
    }

    @PostMapping("/addOffre")
    public ResponseEntity<String> addOffre(@RequestParam("dateOffre") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOffre,
                                           @RequestParam("description") String description,
                                           @RequestParam("affiche") MultipartFile affiche) throws IOException {
        if (affiche.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Image affiche is empty");
        }


        try {
            String afficheFile = saveFile(affiche);
            Offre offre = new Offre();
            offre.setDateOffre(dateOffre);
            offre.setDescription(description);
            offre.setAffiche(afficheFile);
            offre.setEtat(OffreEtat.NON_ARCHIVE);
            offreRepository.save(offre);

            String message = "Offre added successfully";
            return ResponseEntity.ok(message);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }



  /*  @PostMapping("/ajouter")
    public ResponseEntity<Offre> createOffre(@RequestPart("offre") Offre offre, @RequestPart("affiche") MultipartFile affiche) throws IOException {
        if (affiche != null && !affiche.isEmpty()) {
            String imageUrl = uploadImage(affiche);
            offre.setAffiche(imageUrl);
        }
        Offre createdOffre = offreService.createOffre(offre);
        return ResponseEntity.ok(createdOffre);
    }

    private String uploadImage(MultipartFile file) throws IOException {
        // Generate a unique filename for the image file
        String filename = UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1];

        // Create the image directory if it doesn't exist
        File imageDir = new File("C:\\Users\\proinfo\\Desktop\\images");
        if (!imageDir.exists()) {
            imageDir.mkdir();
        }

        // Save the image file to the local directory
        File imageFile = new File(imageDir, filename);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, imageFile.toPath());
        }

        // Return the path to the image file
        return "file:///C:/Users/proinfo/Desktop/images/" + filename;
    }
*/


    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Offre> updateOffre(@PathVariable(value = "id") int id,
                                             @RequestBody Offre offre) {
        Offre updatedOffre = offreService.updateOffre(id, offre);
        if (updatedOffre != null) {
            return ResponseEntity.ok(updatedOffre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOffre(@PathVariable int id) {
        // Appelez la méthode deleteOffre du service
        String result = offreService.deleteOffre(id);
        if (result.equals("offre supprimé")) {
            //return ResponseEntity.ok().build();
            return ResponseEntity.ok("L'offre a été supprimée avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'offre avec l'ID " + id + " n'a pas été trouvée.");
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<OffreDTO>> getOffresListe() {
        try {
            List<OffreDTO> offres = offreService.getOffresListe();
            return ResponseEntity.ok(offres);
        } catch (Exception e) {
            // Gérer l'erreur et renvoyer une réponse appropriée
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/front")
    public ResponseEntity<List<FrontDTO>> getOffresDescriptionAndDate() {
        try {
            List<FrontDTO> offres = offreService.getOffresDescriptionAndDate();
            return ResponseEntity.ok(offres);
        } catch (Exception e) {
            // Handle the error and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{offreId}/reservations")
    public ResponseEntity<List<ReservationResponse>> getReservationsByOffreId(@PathVariable("offreId") int offreId) {
        List<Reservation> reservations = offreService.getReservationsByOffreId(offreId);
        List<ReservationResponse> reservationResponses = reservations.stream()
                .map(reservation -> ReservationResponse.builder()
                        .id(reservation.getId())
                        .offreId(reservation.getOffre().getIdOffre())
                        .userId(reservation.getUser().getId())
                        .dateReservation(reservation.getReservationDate())
                        .status(reservation.getStatus().toString())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservationResponses);
    }

    @PostMapping("/archive/{id}")
    public ResponseEntity<String> archiveOffre(@PathVariable("id") int idOffre) {
        offreService.archiveOffre(idOffre);
        return ResponseEntity.ok("Offre archived successfully");
    }

    @GetMapping("/archive")
    public ResponseEntity<List<FrontDTO>> getArchive() {
        try {
            List<FrontDTO> offres = offreService.getArchive();
            return ResponseEntity.ok(offres);
        } catch (Exception e) {
            // Handle the error and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/archiveCoach")
    public ResponseEntity<List<OffreDTO>> getArchiveCoach() {
        try {
            List<OffreDTO> offres = offreService.getArchiveCoach();
            return ResponseEntity.ok(offres);
        } catch (Exception e) {
            // Handle the error and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }


    @PostMapping("/desarchiver/{id}")
    public ResponseEntity<String> desarchiver(@PathVariable("id") int idOffre) {
        offreService.desarchiver(idOffre);
        return ResponseEntity.ok("Offre unarchived successfully");
    }

    @GetMapping("/offres-a-venir")
    public ResponseEntity<List<OffreDTO>> getOffresAVenir() {
        try {
            List<OffreDTO> offres = offreService.getOffresAVenir();
            return ResponseEntity.ok(offres);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/offres-passees")
    public ResponseEntity<List<OffreDTO>> getOffresPassees() {
        try {
            List<OffreDTO> offres = offreService.getOffresPassees();
            return ResponseEntity.ok(offres);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}






