package com.esprit.edusched.services;



import com.esprit.edusched.entities.Material;

import java.util.List;

public interface IMaterialService {
    Material addMaterial(Material m);
    Material updateMaterial(int idMaterial,Material m);
    void deleteMaterial(int idMaterial);
    List<Material> findAllMaterials();
    Material findMaterialById(int idMaterial);
}
