package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.UploadResponse;
import com.esprit.edusched.dto.UserListRequest;
import com.esprit.edusched.dto.UserResponseImg;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.UserRepository;
import com.esprit.edusched.services.IUserService;
import com.esprit.edusched.services.ProfilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private final ProfilServiceImpl profilService;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final IUserService iUserService;


    public TestController(ProfilServiceImpl profilService, UserRepository userRepository, IUserService iUserService) {
        this.profilService = profilService;
        this.userRepository = userRepository;
        this.iUserService = iUserService;
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
    public ResponseEntity<UploadResponse> updateUser(@RequestParam String name, @RequestPart("file") MultipartFile file) throws IOException {
        User user = profilService.uploadImage(name, file);
        return ResponseEntity.ok(new UploadResponse(user.getName(), user.getEmail(), user.getImage()));
    }

    @GetMapping("/currentUserData")
    public ResponseEntity<UserResponseImg> getUserByEmail(@RequestParam String email) {
        User user=userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email"+ email));
        return ResponseEntity.ok(new UserResponseImg(user.getName(),user.getEmail(),user.getImage()));
    }


//    @GetMapping("/currentUserRegister")
//    public ResponseEntity<UserResponseRegister> getUserByEmailRegister(@RequestParam String email) {
//        User user=userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email"+ email));
//        return ResponseEntity.ok(new UserResponseRegister(user.(),user.isEnabled()));
//    }

}