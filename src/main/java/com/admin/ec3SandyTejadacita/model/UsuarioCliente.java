package com.admin.ec3SandyTejadacita.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "usuario_cliente")
public class UsuarioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String usuario;
    private String password;
    private String rol;

    @OneToOne
    @JoinColumn(name = "id_cliente",
            nullable = false,
            unique = true)
    private Cliente cliente;


}
