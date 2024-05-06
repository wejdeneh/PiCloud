package com.esprit.edusched.entities;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> origin/main
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.Builder;
>>>>>>> origin/main
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
<<<<<<< HEAD
import java.util.List;
import java.util.Set;

=======

import java.util.Set;


>>>>>>> origin/main
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
<<<<<<< HEAD
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ReservationT> reservationTS;
=======
>>>>>>> origin/main

    @Lob
    @Column(length = 10000)
    private byte[] image;

    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens;

<<<<<<< HEAD
=======
    @OneToOne(mappedBy = "user")
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<React> reacts;

>>>>>>> origin/main
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

<<<<<<< HEAD
    @Override
    public String getPassword() {
        return password;
    }
=======

>>>>>>> origin/main

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
<<<<<<< HEAD
=======





  /*  public int getIdUser() {
        return 0;
    }*/


    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   // private List<Reservation> reservations;




>>>>>>> origin/main
}
