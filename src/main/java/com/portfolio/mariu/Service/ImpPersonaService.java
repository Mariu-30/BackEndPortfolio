
package com.portfolio.mariu.Service;

import com.portfolio.mariu.Entity.Persona;
import com.portfolio.mariu.Interface.IPersonaService;
import com.portfolio.mariu.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> person = ipersonaRepository.findAll();
        return person;
    }

    @Override
    public void savePersona(Persona person) {
        ipersonaRepository.save(person);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona person = ipersonaRepository.findById(id).orElse(null);
        return person;
    }
    
}
