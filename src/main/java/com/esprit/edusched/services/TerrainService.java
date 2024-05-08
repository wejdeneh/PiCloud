package com.esprit.edusched.services;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.repositories.TerrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TerrainService implements ITerrainService{
    @Autowired
    TerrainRepository terrainRepo;
    @Override
    public Terrain addTerrain(Terrain t) {
        return terrainRepo.save(t);
    }

    @Override
    public Terrain updateTerrain(int idTerrain,Terrain t) {
        return terrainRepo.save(t);
    }

    @Override
     public void deleteTerrain(int idTerrain) {
        terrainRepo.deleteById(idTerrain);
    }

    @Override
    public List<Terrain> findAllTerrains() {
        return terrainRepo.findAll();
    }

    @Override
    public Terrain findTerrainById(int idTerrain) {
        return terrainRepo.findById(idTerrain).get();
    }


}
