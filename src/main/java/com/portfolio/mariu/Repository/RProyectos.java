package com.portfolio.mariu.Repository;

import com.portfolio.mariu.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByNombreProy(String nombreProy);
    public boolean existsByNombreProy(String nombreProy);
    
}
