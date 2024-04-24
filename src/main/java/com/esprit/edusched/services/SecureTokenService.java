package com.esprit.edusched.services;

import com.esprit.edusched.entities.SecureToken;
import com.esprit.edusched.entities.User;

import java.util.List;
import java.util.Optional;

public interface SecureTokenService {
    SecureToken createSecureToken();
    void saveSecureToken(SecureToken token);
    SecureToken findByToken(String token);
    void removeToken(SecureToken token);
    void removeTokenByToken(String token);
    int getTokenValidityInSeconds();
    List<SecureToken> listofToken();
    Optional<SecureToken> findByUser(User user);

}
