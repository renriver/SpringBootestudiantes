package com.rsr.curso.estudiante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsr.curso.estudiante.entity.Estudiante;
import com.rsr.curso.estudiante.service.EstudianteService;

@RestController//<-- GET,PUT,DELETE,POST
@RequestMapping("/api/v1") //GetMapping(url)

public class EstudianteController {
 
	@Autowired
	private EstudianteService estudianteServ;
	
	@GetMapping(value="/estudiante")
	
	public ResponseEntity <Object> get(){
		Map<String, Object > map=new HashMap<String, Object>();
		 try {
			 //List<Alumno> list  = alumnoService.findAll();
			 List <Estudiante> list=estudianteServ.findAll();
			 return new ResponseEntity<Object>(list,HttpStatus.OK);
		 }
		 catch (Exception e) {
			 map.put("message", e.getMessage());
			 return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	
@GetMapping(value="/estudiante/{id}")
	
	public ResponseEntity <Object> getById(@PathVariable Long id){
		Map<String, Object > map=new HashMap<String, Object>();
		 try {
			 Estudiante est = estudianteServ.findById(id);
			 return new ResponseEntity<Object>(est,HttpStatus.OK);
		 }
		 catch (Exception e) {
			 map.put("message", e.getMessage());
			 return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	
	//id de la tabla estudiante
	
     @PostMapping(value="/estudiante")
     public ResponseEntity<Object> create (@RequestBody Estudiante estudiante ){
    	Map<String,Object> map= new HashMap<String, Object >();
    	try {
    		Estudiante est = estudianteServ.save(estudiante);
    		return new ResponseEntity<Object>(est, HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		map.put("message", e.getMessage());
    		return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
     }
	    
     //metodos para la solicitudes del consumo de servicio
     //actualizar un dato
     
     @PostMapping(value="/estudiante/{id}")
     public ResponseEntity<Object> update (@RequestBody Estudiante estudiante, @PathVariable Long id ){
    	Map<String,Object> map= new HashMap<String, Object >();
    	try {
    		  Estudiante currentEstudiante = estudianteServ.findById(id);
    		   //los datos de tabla
    		  currentEstudiante.setNombre(estudiante.getNombre());
    		  currentEstudiante.setDireccion(estudiante.getDireccion());
    		  currentEstudiante.setTelefono(estudiante.getTelefono());
    		
    		
    		Estudiante est = estudianteServ.save(estudiante);
    		return new ResponseEntity<Object>(est, HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		map.put("message", e.getMessage());
    		return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
     }
     
}
