package com.portfolio.mariu.Controller;

import com.portfolio.mariu.Dto.DtoEducacion;
import com.portfolio.mariu.Entity.Educacion;
import com.portfolio.mariu.Security.Controller.Mensaje;
import com.portfolio.mariu.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontendmariu-2732f.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    //Crear una nueva educacion
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeducacion){      
        if(StringUtils.isBlank(dtoeducacion.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo obtenido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByTitulo(dtoeducacion.getTitulo()))
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoeducacion.getTitulo(), dtoeducacion.getNombreInst(), dtoeducacion.getFechaFin(), dtoeducacion.getEsEstudioActual(), dtoeducacion.getImagen());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoeducacion){
        //Verifica si existe el Id
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        //Compara si el nuevo titulo esta repetido
        if(sEducacion.existsByTitulo(dtoeducacion.getTitulo()) && sEducacion.getByTitulo(dtoeducacion.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Este titulo ya existe"), HttpStatus.BAD_REQUEST);
        //Verifica si el campo esta vacio
        if(StringUtils.isBlank(dtoeducacion.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setTitulo(dtoeducacion.getTitulo());
        educacion.setNombreInst(dtoeducacion.getNombreInst());
        educacion.setFechaFin(dtoeducacion.getFechaFin());
        educacion.setEsEstudioActual(dtoeducacion.getEsEstudioActual());
        educacion.setImagen(dtoeducacion.getImagen());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
}
