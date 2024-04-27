package com.esprit.edusched.controllers;


import com.esprit.edusched.entities.Material;
import com.esprit.edusched.services.IMaterialService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MaterialController {
    @Autowired
    IMaterialService iMaterialService;
    @PostMapping("/addMaterial")
    public Material addMaterial(@RequestBody Material m){
        return iMaterialService.addMaterial(m);
    }

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

}
