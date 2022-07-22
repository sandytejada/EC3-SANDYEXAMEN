package com.admin.ec3SandyTejadacita.service;

import com.admin.ec3SandyTejadacita.model.Cliente;
import com.admin.ec3SandyTejadacita.model.UsuarioCliente;

import java.util.List;

public interface IUsuarioClienteService {

    UsuarioCliente guardar(UsuarioCliente UCliente);
    void actualizar(UsuarioCliente UCliente);
    void eliminar(int id_usuario);
    List<UsuarioCliente> listar();
    UsuarioCliente obtenerPorId(int id_usuario);
}
