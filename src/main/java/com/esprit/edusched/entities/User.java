package com.esprit.edusched.entities;

<<<<<<< HEAD
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.Builder;
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;
import java.util.Set;

=======

import java.util.Set;


>>>>>>> origin/main
=======

import java.util.Set;


>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
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
<<<<<<< HEAD
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ReservationT> reservationTS;
=======
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

    @Lob
    @Column(length = 10000)
    private byte[] image;

    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens;

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
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

<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public String getPassword() {
        return password;
    }
=======

>>>>>>> origin/main
=======

>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

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
<<<<<<< HEAD
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda





  /*  public int getIdUser() {
        return 0;
    }*/


    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   // private List<Reservation> reservations;




<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
}
