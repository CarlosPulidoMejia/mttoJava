package com.bim.reporte.mantenimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.mantenimiento.response.TipoEstadoProyectoResponse;
import com.bim.reporte.mantenimiento.service.TipoEstadoProyectoService;

@RestController
@CrossOrigin("*")
@RequestMapping("catalogos")
public class TipoEstadoController {

	@Autowired
	private TipoEstadoProyectoService estadoProyectoService;
	
	@GetMapping("/tipoEstado")
	public ResponseEntity<List<TipoEstadoProyectoResponse>> listaEstado(){
		return ResponseEntity.ok(estadoProyectoService.listaEstado());
	}
}
