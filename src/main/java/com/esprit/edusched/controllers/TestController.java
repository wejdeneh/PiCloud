package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.RequestDto;
import com.esprit.edusched.dto.UploadResponse;
import com.esprit.edusched.dto.UserListRequest;
import com.esprit.edusched.dto.UserResponseImg;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.enums.EnumClasse;
import com.esprit.edusched.enums.EnumSpecialite;
import com.esprit.edusched.repositories.UserRepository;
import com.esprit.edusched.services.ProfilServiceImpl;
import com.esprit.edusched.services.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private final UserServiceImpl userService;
    @Autowired
    private final ProfilServiceImpl profilService;
    @Autowired
    private final UserRepository userRepository;


    public TestController(UserServiceImpl userService, ProfilServiceImpl profilService, UserRepository userRepository) {
        this.userService = userService;
        this.profilService = profilService;
        this.userRepository = userRepository;

    }

    @GetMapping("/list")
    public ResponseEntity<List<UserListRequest>> listUser() {
        List<User> listAllUser = userRepository.findAll();

        List<UserListRequest> userListRequests = new ArrayList<>();

        for (User user : listAllUser) {
            UserListRequest userListRequest = new UserListRequest();
            userListRequest.setName(user.getName());
            userListRequest.setEmail(user.getEmail());
            userListRequest.setEnabled(user.isEnabled());
            userListRequest.setAccountNonLocked(user.isAccountNonLocked());
            userListRequests.add(userListRequest);
        }

        return ResponseEntity.ok(userListRequests);
    }


    @PostMapping("/user")
    public ResponseEntity<UploadResponse> updateUser(@RequestParam String name,@RequestParam String email, @RequestPart("file") MultipartFile file,@RequestParam  EnumClasse enumClasse,
    @RequestParam EnumSpecialite enumSpecialite, @RequestParam String number, @RequestParam String nationality) throws IOException {
        User user = profilService.uploadImage(name,email, file,enumClasse,enumSpecialite,number,nationality);
        return ResponseEntity.ok(new UploadResponse(user.getName(), user.getEmail(), user.getImage(),user.getEnumClasse(),user.getEnumSpecialite(),user.getNumber(),user.getNationality(),user.getCreationDate()));
    }

    @GetMapping("/currentUserData")
    public ResponseEntity<UploadResponse> getUserByEmail(@RequestParam String email) {
        User user=userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email"+ email));
        return ResponseEntity.ok(new UploadResponse(user.getName(), user.getEmail(), user.getImage(),user.getEnumClasse(),user.getEnumSpecialite(),user.getNumber(),user.getNationality(),user.getCreationDate()));
    }
//    @GetMapping("/currentUserRegister")
//    public ResponseEntity<UserResponseRegister> getUserByEmailRegister(@RequestParam String email) {
//        User user=userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email"+ email));
//        return ResponseEntity.ok(new UserResponseRegister(user.(),user.isEnabled()));
//    }
    @PostMapping("/ban")
    public void banUser(@RequestBody RequestDto requestDto) {
        userService.banUser(requestDto.email, requestDto.banDurationInDays);
    }

    @PostMapping("/unban")
    public void unbanUser(@RequestBody String email) {
        userService.unbanUser(email);
    }

    @GetMapping("/is-banned")
    public boolean isUserBanned(@RequestParam String email) {
        return userService.isUserBanned(email);
    }

    @GetMapping("/user-registration-stats")
    public List<Object[]> getUserRegistrationStats() {
        return userRepository.countUsersByRegistrationMonth();
    }

}