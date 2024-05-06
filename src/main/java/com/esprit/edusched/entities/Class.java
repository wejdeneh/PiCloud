package com.esprit.edusched.entities;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> origin/main
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "classes")
public class Class  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idC")
    private Long idC;
    private int num;
    @OneToMany( mappedBy="clas", cascade = CascadeType.ALL)
    private Set<ReservationC> reservationCS;
    @ManyToOne
    @JoinColumn(name = "idB")
    private Bloc bloc;
<<<<<<< HEAD
    private boolean liberated;
=======
    private boolean liberated = true;
>>>>>>> origin/main

}
