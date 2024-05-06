<<<<<<< HEAD
package com.esprit.edusched.entities;

<<<<<<< HEAD
=======

package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> origin/main
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.time.LocalDate;
import java.time.LocalTime;
>>>>>>> origin/main
=======
import java.time.LocalDate;
import java.time.LocalTime;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import java.util.Date;

@Data
@Entity
@Table(name = "reservationc")
public class ReservationC implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idR")
    private Long idR;
    @Temporal(TemporalType.DATE)
<<<<<<< HEAD
<<<<<<< HEAD
    private Date startd;
=======
    private LocalDate startd;
    private LocalTime startHour;
    private LocalTime finalHour;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    @Temporal(TemporalType.DATE)

    private LocalDate finald;

    private String state;
    @ManyToOne
    @JoinColumn(name = "idC")
    private Class clas;


}
=======
    private LocalDate startd;
    private LocalTime startHour;
    private LocalTime finalHour;
    @Temporal(TemporalType.DATE)

    private LocalDate finald;

    private String state;
    @ManyToOne
    @JoinColumn(name = "idC")
    private Class clas;


}
>>>>>>> origin/main
