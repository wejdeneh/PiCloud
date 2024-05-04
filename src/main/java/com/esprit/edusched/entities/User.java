package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Lob
    @Column(length = 10000)
    private byte[] image;

    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens;

    @OneToOne(mappedBy = "user")
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;//switch it to true or we will not be able to connect our users
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;//switch it to true or we will not be able to connect our users
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//switch it to true or we will not be able to connect our users
    }

    @Override
    public boolean isEnabled() {
        return enabled;//switch it to true or we will not be able to connect our users
    }
}
