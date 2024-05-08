package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.UserActionHistory;
import com.esprit.edusched.services.UserActionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class UserActionHistoryController {

    @Autowired
    private UserActionHistoryService historyService;

    @PostMapping
    public UserActionHistory saveUserAction(@RequestBody UserActionHistory history) {
        return historyService.saveUserAction(history);
    }

    @GetMapping("/{userId}")
    public List<UserActionHistory> getUserActionHistory(@PathVariable int userId) {
        return historyService.getUserActionHistory(userId);
    }

    // Autres endpoints pour la mise à jour et la suppression

    @DeleteMapping("/delete/{historyId}")
    public void deleteUserActionHistory(@PathVariable Long historyId) {
        historyService.deleteUserActionHistory(historyId);
    }
    @DeleteMapping("/deleteSelected")
    public void deleteSelectedHistory(@RequestBody List<Long> ids) {
        historyService.deleteSelectedHistory(ids);
    }


}
