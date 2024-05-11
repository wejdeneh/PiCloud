package com.abir.pi.repositories;

import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
