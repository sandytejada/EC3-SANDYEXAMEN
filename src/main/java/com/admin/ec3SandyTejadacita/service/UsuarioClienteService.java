package com.admin.ec3SandyTejadacita.service;

import com.admin.ec3SandyTejadacita.model.UsuarioCliente;
import com.admin.ec3SandyTejadacita.repository.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioClienteService implements IUsuarioClienteService{

    @Autowired
    private UsuarioClienteRepository repository;

    @Override
    public UsuarioCliente guardar(UsuarioCliente UCliente) {

        return repository.save(UCliente);
    }

    @Override
    public void actualizar(UsuarioCliente UCliente) {
        repository.saveAndFlush(UCliente);
    }

    @Override
    public void eliminar(int id_usuario) {
        repository.deleteById(id_usuario);
    }

    @Override
    public List<UsuarioCliente> listar() {

        return repository.findAll();
    }

    @Override
    public UsuarioCliente obtenerPorId(int id_usuario) {

        return repository.findById(id_usuario).orElse(null);
    }
}
