package com.esprit.edusched.services;

import com.esprit.edusched.dto.ReactDTO;
import com.esprit.edusched.entities.*;

import com.esprit.edusched.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReactService {



    private final ReactRepository reactRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OffreRepository offreRepository;



    public ReactService(ReactRepository reactRepository) {
        this.reactRepository = reactRepository;
    }



    public React addReact(ReactDTO reactDTO, ReactType reactType) {
        // Create a new React entity
        React react = new React();

        // Find the User entity by its ID
        User user = userRepository.findById(reactDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Find the Offre entity by its ID
        Offre offre = offreRepository.findById(reactDTO.getOffreId())
                .orElseThrow(() -> new IllegalArgumentException("Offre not found"));

        // Set the User, Offre, and other properties in the React entity
        react.setUser(user);
        react.setOffre(offre);
        react.setReactType(reactType);
        react.setTimestamp(LocalDateTime.now());

        // Save the new React entity to the database
        return reactRepository.save(react);
    }




    public void deleteReact(Long id) {
        reactRepository.deleteById(id);
    }

    public React updateReact(Long id, ReactDTO reactDTO) {
        Optional<React> reactOptional = reactRepository.findById(id);
        if (reactOptional.isPresent()) {
            React react = reactOptional.get();
            react.setReactType(reactDTO.getReactType());

            // Assuming idOffre and idUser are available in ReactDTO
            Optional<User> userOptional = userRepository.findById(reactDTO.getUserId());
            userOptional.ifPresent(react::setUser);

            Optional<Offre> offreOptional = offreRepository.findById(reactDTO.getOffreId());
            offreOptional.ifPresent(react::setOffre);

            react.setTimestamp(LocalDateTime.now());

            return reactRepository.save(react);
        } else {
            return null;
        }
    }

}
