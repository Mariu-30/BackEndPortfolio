package com.portfolio.mariu.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String nombreInst;
    private String fechaFin;
    @NotBlank
    private String esEstudioActual;
    @NotBlank
    private String imagen;
    
    //Constructores

    public DtoEducacion() {
    }

    public DtoEducacion(String titulo, String nombreInst, String fechaFin, String esEstudioActual, String imagen) {
        this.titulo = titulo;
        this.nombreInst = nombreInst;
        this.fechaFin = fechaFin;
        this.esEstudioActual = esEstudioActual;
        this.imagen = imagen;
    }
        

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreInst() {
        return nombreInst;
    }

    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEsEstudioActual() {
        return esEstudioActual;
    }

    public void setEsEstudioActual(String esEstudioActual) {
        this.esEstudioActual = esEstudioActual;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
