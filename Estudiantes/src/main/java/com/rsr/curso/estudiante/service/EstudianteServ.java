package com.rsr.curso.estudiante.service;

import java.util.List;

import com.rsr.curso.estudiante.entity.Estudiante;

public interface EstudianteServ {

	 public List<Estudiante> findAll();
	 public Estudiante save(Estudiante estudiante);
	 public void delete(Estudiante estudiante);
	 public Estudiante findById(Long id);
}
