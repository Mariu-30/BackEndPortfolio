package com.portfolio.mariu.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String nombreInst;
    private String fechaFin;
    private String esEstudioActual;
    private String imagen;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    //@JoinColumn(name="persona_id")
    private Persona persona;
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String titulo, String nombreInst, String fechaFin, String esEstudioActual, String imagen) {
        this.titulo = titulo;
        this.nombreInst = nombreInst;
        this.fechaFin = fechaFin;
        this.esEstudioActual = esEstudioActual;
        this.imagen = imagen;
    }

    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
