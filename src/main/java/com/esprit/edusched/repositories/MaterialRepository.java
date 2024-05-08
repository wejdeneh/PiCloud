package com.esprit.edusched.repositories;


import com.esprit.edusched.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material,Integer> {
}
