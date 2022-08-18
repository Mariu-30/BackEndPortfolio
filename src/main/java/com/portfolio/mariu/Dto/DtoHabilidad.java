package com.portfolio.mariu.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHabilidad {
    @NotBlank
    private String nombreHab;
    @NotBlank
    private int porcentaje;
    
    //Constructores

    public DtoHabilidad() {
    }

    public DtoHabilidad(String nombreHab, int porcentaje) {
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
    }
    
    //Getters y Setters

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
