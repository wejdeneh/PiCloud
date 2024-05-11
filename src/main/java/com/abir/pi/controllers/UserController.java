package com.abir.pi.controllers;

import com.abir.pi.entities.Terrain;
import com.abir.pi.entities.User;
import com.abir.pi.services.IReservationTService;
import com.abir.pi.services.ITerrainService;
import com.abir.pi.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {
    @Autowired
    IUserService iUserService;
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return iUserService.addUser(user);
    }
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return iUserService.updateUser(user);
    }
    @DeleteMapping("/deleteUser/{idUser}")
    public void deleteUser(@PathVariable("idUser") int idUser){
        iUserService.deleteUser(idUser);
    }
    @GetMapping("/findAllUsers")
    public List<User> findAllUsers(){
        return iUserService.findAllUsers();
    }
    @GetMapping("/findUserById/{idUser}")
    public User findUserById(@PathVariable("idUser") int idUser){
        return iUserService.findUserById(idUser);
    }

}
