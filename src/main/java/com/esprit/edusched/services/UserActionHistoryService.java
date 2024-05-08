package com.esprit.edusched.services;

import com.esprit.edusched.entities.UserActionHistory;
import com.esprit.edusched.repositories.UserActionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionHistoryService {

    @Autowired
    private UserActionHistoryRepository historyRepository;

    public UserActionHistory saveUserAction(UserActionHistory history) {
        return historyRepository.save(history);
    }

    public List<UserActionHistory> getUserActionHistory(int userId) {
        return historyRepository.findByUserId(userId);
    }

    public void deleteUserActionHistory(Long historyId) {
        // Logique pour supprimer l'historique de l'utilisateur par son ID
        historyRepository.deleteById(historyId);
    }
    public void deleteSelectedHistory(List<Long> ids) {
        historyRepository.deleteAllById(ids);
    }

    // Autres méthodes de service pour la mise à jour et la suppression
}
