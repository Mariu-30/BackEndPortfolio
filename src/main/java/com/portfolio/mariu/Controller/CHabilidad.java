package com.portfolio.mariu.Controller;

import com.portfolio.mariu.Dto.DtoHabilidad;
import com.portfolio.mariu.Entity.Habilidad;
import com.portfolio.mariu.Security.Controller.Mensaje;
import com.portfolio.mariu.Service.SHabilidad;
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
@RequestMapping("/habilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {
    @Autowired
    SHabilidad sHabilidad;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id) {
        if (!sHabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Habilidad habilidad = sHabilidad.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    //Crear una nueva habilidad
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtohabilidad){      
        if(StringUtils.isBlank(dtohabilidad.getNombreHab()))
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHabilidad.existsByNombreHab(dtohabilidad.getNombreHab()))
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = new Habilidad(dtohabilidad.getNombreHab(), dtohabilidad.getPorcentaje());
        sHabilidad.save(habilidad);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtohabilidad){
        //Verifica si existe el Id
        if(!sHabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        //Compara si la habilidad esta repetido
        if(sHabilidad.existsByNombreHab(dtohabilidad.getNombreHab()) && sHabilidad.getByNombreHab(dtohabilidad.getNombreHab()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esta habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //Verifica si el campo esta vacio
        if(StringUtils.isBlank(dtohabilidad.getNombreHab()))
            return new ResponseEntity(new Mensaje("El nombre la habilidad es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = sHabilidad.getOne(id).get();
        habilidad.setNombreHab(dtohabilidad.getNombreHab());
        habilidad.setPorcentaje(dtohabilidad.getPorcentaje());
        
        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHabilidad.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sHabilidad.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
}
