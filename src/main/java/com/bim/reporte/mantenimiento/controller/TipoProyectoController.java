package com.bim.reporte.mantenimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.mantenimiento.request.DetalleTipoProyectoRequest;
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
	
	@PutMapping("/modificarTipoProyecto/{id}")
	public void modificarTipoProyecto(@PathVariable int id, @RequestBody DetalleTipoProyectoRequest detalleReq) {
		proyectoService.modificarTipoProyecto(id, detalleReq);
	}
	
	@PostMapping("/crearTipoProyecto")
	public void crearTipoProyecto(@RequestBody DetalleTipoProyectoRequest tipoProyecto) {
		proyectoService.crearTipoProyecto(tipoProyecto);
	}
}
