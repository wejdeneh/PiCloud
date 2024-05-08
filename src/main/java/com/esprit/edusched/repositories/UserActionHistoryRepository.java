package com.esprit.edusched.repositories;

import com.esprit.edusched.entities.UserActionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActionHistoryRepository extends JpaRepository<UserActionHistory, Long> {
    List<UserActionHistory> findByUserId(int userId);
}

