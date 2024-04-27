package com.esprit.edusched.services;


import com.esprit.edusched.entities.Material;
import com.esprit.edusched.repositories.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialService implements IMaterialService{
    @Autowired
    MaterialRepository materialRepo;
    @Override
    public Material addMaterial(Material m) {
        return materialRepo.save(m);
    }

   @Override
    public Material updateMaterial(int idMaterial,Material m) {
        return materialRepo.save(m);
    }

    @Override
    public void deleteMaterial(int idMaterial) {
        materialRepo.deleteById(idMaterial);
    }

    @Override
    public List<Material> findAllMaterials() {
        return materialRepo.findAll();
    }

    @Override
    public Material findMaterialById(int idMaterial) {
        return materialRepo.findById(idMaterial).get();
    }
}
