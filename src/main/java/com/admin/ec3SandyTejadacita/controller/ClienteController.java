package com.admin.ec3SandyTejadacita.controller;


import com.admin.ec3SandyTejadacita.model.Cliente;
import com.admin.ec3SandyTejadacita.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Cliente cliente){
        Map<String, Object> response = new HashMap<>();
        service.guardar(cliente);
        response.put("cliente", cliente);
        response.put("mensaje", "el cliente".concat(cliente.getNombre()).concat("ha sido registrado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_cliente}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_cliente) {
        Cliente c =service.obtenerPorId(id_cliente);
        if(c != null) {
            return  new ResponseEntity<Cliente>(service.obtenerPorId(id_cliente),HttpStatus.OK);
        }
        return  new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_cliente}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_cliente) {
        Cliente c =service.obtenerPorId(id_cliente);
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.eliminar(id_cliente);
            response.put("mensaje", "Cliente '" .concat(c.getNombre()).concat("' eliminado con exito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Cliente cliente) {
        Cliente c = service.obtenerPorId(cliente.getId_cliente());
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.actualizar(cliente);
            response.put("producto: ", cliente);
            response.put("mensaje", "Cliente " + cliente.getNombre() + " actualizado con exito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
