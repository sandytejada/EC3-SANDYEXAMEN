package com.admin.ec3SandyTejadacita.controller;


import com.admin.ec3SandyTejadacita.model.UsuarioCliente;
import com.admin.ec3SandyTejadacita.service.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/usuario_cliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService service;

    @GetMapping("/listar")
    public List<UsuarioCliente> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody UsuarioCliente usuarioCliente){
        Map<String, Object> response = new HashMap<>();
        service.guardar(usuarioCliente);
        response.put("usuario", usuarioCliente);
        response.put("mensaje", "el usuario".concat(usuarioCliente.getUsuario()).concat("ha sido creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_usuario}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_usuario) {
        UsuarioCliente uc =service.obtenerPorId(id_usuario);
        if(uc != null) {
            return  new ResponseEntity<UsuarioCliente>(service.obtenerPorId(id_usuario),HttpStatus.OK);
        }
        return  new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_usuario}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_usuario) {
        UsuarioCliente uc =service.obtenerPorId(id_usuario);
        Map<String, Object> response = new HashMap<>();
        if(uc != null) {
            service.eliminar(id_usuario);
            response.put("mensaje", "UsuarioCliente '" .concat(uc.getUsuario()).concat("' eliminado con exito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody UsuarioCliente usuarioCliente) {
        UsuarioCliente uc = service.obtenerPorId(usuarioCliente.getId_usuario());
        Map<String, Object> response = new HashMap<>();
        if(uc != null) {
            service.actualizar(usuarioCliente);
            response.put("UsuarioCliente: ", usuarioCliente);
            response.put("mensaje", "UsuarioCliente " + usuarioCliente.getUsuario() + " actualizado con exito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
