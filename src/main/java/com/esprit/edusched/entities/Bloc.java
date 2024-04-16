package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "blocs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idB")
    private Long idB;
    private String name;
    @OneToMany(mappedBy="bloc", cascade = CascadeType.ALL)
    private Set<Class> classes;

}
