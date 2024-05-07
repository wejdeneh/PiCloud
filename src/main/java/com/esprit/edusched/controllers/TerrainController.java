package com.esprit.edusched.controllers;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.services.IReservationTService;
import com.esprit.edusched.services.ITerrainService;
//import com.esprit.edusched.services.SearchServiceTerrain;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class TerrainController {
    @Autowired
    ITerrainService iTerrainService;
    @Autowired
    IReservationTService iReservationTService;
   /* @Autowired
    private SearchServiceTerrain searchServiceTerrain;*/
    @PostMapping("/addTerrain")
    public Terrain addTerrain(@RequestBody Terrain t){
        return iTerrainService.addTerrain(t);
    }
    @PutMapping("/updateTerrain/{idTerrain}")
    public Terrain updateReservationT(@PathVariable("idTerrain") int idTerrain,@RequestBody Terrain t){
        Terrain ExistingT = iTerrainService.findTerrainById(idTerrain);
        if(ExistingT==null){
            throw new EntityNotFoundException("Terrain not found with ID:"+idTerrain);
        }
        if(t.getName()!=null){
            ExistingT.setName(t.getName());
        }else{
            ExistingT.setName(ExistingT.getName());
        }
        if(t.getDescription()!=null){
            ExistingT.setDescription(t.getDescription());
        }else{
            ExistingT.setDescription(ExistingT.getDescription());
        }
        /*
        if(t.getLongtitude()!=0){
            ExistingT.setLongtitude(t.getLongtitude());
        }else{
            ExistingT.setLongtitude(ExistingT.getLongtitude());
        }
        if(t.getLatitude()!=0){
            ExistingT.setLatitude(t.getLatitude());
        }else{
            ExistingT.setLatitude(ExistingT.getLatitude());
        }*/
        return iTerrainService.updateTerrain(idTerrain,ExistingT);
    }
    /*@PutMapping("/updateTerrain")
    public Terrain updateTerrain(@RequestBody Terrain t){
        return iTerrainService.updateTerrain(t);
    }*/
    @DeleteMapping("/deleteTerrain/{idTerrain}")
    public void deleteTerrain(@PathVariable("idTerrain") int idTerrain){
        iTerrainService.deleteTerrain(idTerrain);
    }
    @GetMapping("/findAllTerrains")
    public List<Terrain> findAllTerrains(){
        return iTerrainService.findAllTerrains();
    }
    @GetMapping("/findTerrainById/{idTerrain}")
    public Terrain findTerrainById(@PathVariable("idTerrain") int idTerrain){
        return iTerrainService.findTerrainById(idTerrain);
    }
/*

    @GetMapping("/terrain/search")
    public List<Terrain> searchTerrainByName(@RequestParam("name") String name){
        return searchServiceTerrain.findTerrainByName(name);
    }*/

    


}
