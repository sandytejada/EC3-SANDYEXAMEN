package com.admin.ec3SandyTejadacita.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "hospitales")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hospital;
    private String nombre;
    private String descripcion;
    private String distrito;

    @JsonIgnoreProperties({"hospital"})
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "hospital_cliente",
            joinColumns = @JoinColumn(
                    name = "id_hospital",
                    nullable = false,
                    unique = true

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_cliente",
                    nullable = false,
                    unique = true
            )

    )
    private List<Cliente>clientes = new ArrayList<>();
}
