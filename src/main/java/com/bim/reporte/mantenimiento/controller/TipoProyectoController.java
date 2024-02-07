package com.bim.reporte.mantenimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.mantenimiento.response.TipoProyectoResponse;
import com.bim.reporte.mantenimiento.service.TipoProyectoService;

@RestController
@CrossOrigin("*")
@RequestMapping("catalogos")
public class TipoProyectoController {

	@Autowired
	private TipoProyectoService proyectoService;
	
	@GetMapping("/tipoProyecto")
	public ResponseEntity<List<TipoProyectoResponse>> listaTipoProy(){
		
		return ResponseEntity.ok(proyectoService.listarTipoProyecto());
	}
}
