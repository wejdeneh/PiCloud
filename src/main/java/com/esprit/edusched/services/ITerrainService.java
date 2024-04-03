package com.esprit.edusched.services;

import com.esprit.edusched.entities.Terrain;

import java.util.List;

public interface ITerrainService {
    Terrain addTerrain(Terrain t);
    Terrain updateTerrain(int idTerrain,Terrain t);
    void deleteTerrain(int idTerrain);
    List<Terrain> findAllTerrains();
    Terrain findTerrainById(int idTerrain);
}
