package com.admin.ec3SandyTejadacita.controller;


import com.admin.ec3SandyTejadacita.model.Hospital;

import com.admin.ec3SandyTejadacita.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @GetMapping("/listar")
    public List<Hospital> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Hospital hospital){
        Map<String, Object> response = new HashMap<>();
        service.guardar(hospital);
        response.put("hospítal", hospital);
        response.put("mensaje", "el hospital".concat(hospital.getNombre()).concat("ha sido creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_hospital}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_hospital) {
        Hospital h =service.obtenerPorId(id_hospital);
        if(h != null) {
            return  new ResponseEntity<Hospital>(service.obtenerPorId(id_hospital),HttpStatus.OK);
        }
        return  new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_hospital}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_hospital) {
        Hospital h =service.obtenerPorId(id_hospital);
        Map<String, Object> response = new HashMap<>();
        if(h != null) {
            service.eliminar(id_hospital);
            response.put("mensaje", "Hospital '" .concat(h.getNombre()).concat("' eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Hospital hospital) {
        Hospital h = service.obtenerPorId(hospital.getId_hospital());
        Map<String, Object> response = new HashMap<>();
        if(h != null) {
            service.actualizar(hospital);
            response.put("hospital: ", hospital);
            response.put("mensaje", "Hospital " + hospital.getNombre() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
