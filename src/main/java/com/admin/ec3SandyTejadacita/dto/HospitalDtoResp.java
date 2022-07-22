package com.admin.ec3SandyTejadacita.dto;

public class HospitalDtoResp {
    private Integer id_hospital;
    private String nombre;
    private String descripcion;
    private String distrito;

    public Integer getId_hospital() {
        return id_hospital;
    }

    public void setId_hospital(Integer id_hospital) {
        this.id_hospital = id_hospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
