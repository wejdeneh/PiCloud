package com.abir.pi.services;

import com.abir.pi.entities.ReservationT;
import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;
import com.abir.pi.repositories.TerrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public Date findFirstDate(ReservationT reservationT){
        return reservationT.getDate_debut();
    }
    /*public Date findLastDate(ReservationT reservationT){
        return  reservationT.getDate_fin();

    }
    public void findBetween(Date from, Date to){

    }*/



}
