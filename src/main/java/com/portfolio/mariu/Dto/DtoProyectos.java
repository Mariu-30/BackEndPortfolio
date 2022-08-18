package com.portfolio.mariu.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyectos {
    @NotBlank
    private String nombreProy;
    @NotBlank
    private String descripcionProy;
    @NotBlank
    private String imgProy;
    @NotBlank
    private String urlProy;
    
    //Constructores

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProy, String descripcionProy, String imgProy, String urlProy) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.imgProy = imgProy;
        this.urlProy = urlProy;
    }
    
    //Getters y Setters

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getDescripcionProy() {
        return descripcionProy;
    }

    public void setDescripcionProy(String descripcionProy) {
        this.descripcionProy = descripcionProy;
    }

    public String getImgProy() {
        return imgProy;
    }

    public void setImgProy(String imgProy) {
        this.imgProy = imgProy;
    }

    public String getUrlProy() {
        return urlProy;
    }

    public void setUrlProy(String urlProy) {
        this.urlProy = urlProy;
    }
    

}
