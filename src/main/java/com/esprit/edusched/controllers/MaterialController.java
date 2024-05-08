package com.esprit.edusched.controllers;


import com.esprit.edusched.entities.Material;
import com.esprit.edusched.services.IMaterialService;
import com.esprit.edusched.services.FileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MaterialController {
    @Autowired
    IMaterialService iMaterialService;
     FileService fileService;
     private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/addMaterial")
    public Material addMaterial(@RequestBody Material m){
        return iMaterialService.addMaterial(m);
    }
/**
     @PostMapping("/addMaterial")
     public Material addMaterial(@RequestBody Map<String, Object> requestBody) throws Exception {
         String fileName = (String) requestBody.get("fileName");
         String pictureData = (String) requestBody.get("pictureData");
         Material material = objectMapper.convertValue(requestBody.get("material"), Material.class);
      
         System.err.println(fileName + " eeee");
         String imageURL = fileService.uploadPicture(fileName, pictureData); // Upload picture and get URL
         material.setImage(imageURL); // Set the image URL in the Material object
     
         return iMaterialService.addMaterial(material);
     }
   **/
     

    @PutMapping("/updateMaterial/{idMaterial}")
    public Material updateReservationM(@PathVariable("idMaterial") int idMaterial,@RequestBody Material m){
        Material ExistingM = iMaterialService.findMaterialById(idMaterial);
        if(ExistingM==null){
            throw new EntityNotFoundException("Material not found with ID:"+idMaterial);
        }
        if(m.getName()!=null){
            ExistingM.setName(m.getName());
        }else{
            ExistingM.setName(ExistingM.getName());
        }
        if(m.getDescription()!=null){
            ExistingM.setDescription(m.getDescription());
        }else{
            ExistingM.setDescription(ExistingM.getDescription());
        }
        return iMaterialService.updateMaterial(idMaterial,ExistingM);
    }


    @DeleteMapping("/deleteMaterial/{idMaterial}")
    public void deleteMaterial(@PathVariable("idMaterial") int idMaterial){
        iMaterialService.deleteMaterial(idMaterial);
    }
    @GetMapping("/findAllMaterials")
    public List<Material> findAllMaterials(){
        return iMaterialService.findAllMaterials();
    }
    @GetMapping("/findMaterialById/{idMaterial}")
    public Material findMaterialById(@PathVariable("idMaterial") int idMaterial){
        return iMaterialService.findMaterialById(idMaterial);
    }
    @PostMapping("/upload")
    public void uploadPicture(@RequestParam String fileName, @RequestParam String pictureData) throws Exception {
        fileService.uploadPicture(fileName, pictureData);
    }



}
