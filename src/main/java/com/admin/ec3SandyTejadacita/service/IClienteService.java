package com.admin.ec3SandyTejadacita.service;

import com.admin.ec3SandyTejadacita.model.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente guardar(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(int id_cliente);
    List<Cliente> listar();
    Cliente obtenerPorId(int id_cliente);
}

