package com.portfolio.mariu.Interface;

import com.portfolio.mariu.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer lista
    public List<Persona> getPersona();
    //Crear objeto persona
    public void savePersona(Persona person);
    //Eliminar un objeto persona
    public void deletePersona(Long id);
    //Buscar persona
    public Persona findPersona(Long id);
}
