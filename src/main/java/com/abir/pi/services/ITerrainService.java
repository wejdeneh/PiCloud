package com.abir.pi.services;

import com.abir.pi.entities.ReservationT;
import com.abir.pi.entities.Terrain;

import java.util.List;

public interface ITerrainService {
    Terrain addTerrain(Terrain t);
    Terrain updateTerrain(int idTerrain,Terrain t);
    void deleteTerrain(int idTerrain);
    List<Terrain> findAllTerrains();
    Terrain findTerrainById(int idTerrain);
}
