<<<<<<< HEAD
package com.esprit.edusched.entities;

=======

package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> origin/main
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.time.LocalDate;
import java.time.LocalTime;
>>>>>>> origin/main
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
    private Date startd;
    @Temporal(TemporalType.DATE)
    private Date finald;
    private String state;
    @ManyToOne
    @JoinColumn(name = "idC")
    @JsonIgnoreProperties({"reservationCS"})
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
