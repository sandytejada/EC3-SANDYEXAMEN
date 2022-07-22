package com.admin.ec3SandyTejadacita.service;

import com.admin.ec3SandyTejadacita.model.Cliente;
import com.admin.ec3SandyTejadacita.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente guardar(Cliente cliente) {

        return repository.save(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        repository.saveAndFlush(cliente);
    }

    @Override
    public void eliminar(int id_cliente) {
        repository.deleteById(id_cliente);
    }

    @Override
    public List<Cliente> listar() {

        return repository.findAll();
    }

    @Override
    public Cliente obtenerPorId(int id_cliente) {

        return repository.findById(id_cliente).orElse(null);
    }
}
