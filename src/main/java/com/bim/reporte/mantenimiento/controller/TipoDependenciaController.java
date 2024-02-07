package com.bim.reporte.mantenimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.mantenimiento.response.TipoDependenciaResponse;
import com.bim.reporte.mantenimiento.service.TipoDependenciaService;
import com.bim.reporte.mantenimiento.request.DetalleDependenciaRequest;



@RestController
@CrossOrigin("*")
@RequestMapping("catalogos")
public class TipoDependenciaController {

	@Autowired
	private TipoDependenciaService dependenciaService;
	
	
	@GetMapping("/tipoDependencia")
	public ResponseEntity<List<TipoDependenciaResponse>> listaDependencia(){
		return ResponseEntity.ok(dependenciaService.listaDependencia());
	}

	@PutMapping("/detalleDependencia/{id}")
	public void guardarDependencia (@PathVariable int id, @RequestBody DetalleDependenciaRequest detalleReq) {
		dependenciaService.modificarDependencia(id, detalleReq);
	}
	
}