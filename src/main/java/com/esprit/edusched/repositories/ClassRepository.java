package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClassRepository extends JpaRepository<Class,Long> {
}
