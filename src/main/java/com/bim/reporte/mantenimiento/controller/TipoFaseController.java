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

import com.bim.reporte.mantenimiento.request.DetalleFaseRequest;
import com.bim.reporte.mantenimiento.response.TipoFaseResponse;
import com.bim.reporte.mantenimiento.service.TipoFaseService;

@RestController
@CrossOrigin("*")
@RequestMapping("catalogos")
public class TipoFaseController {
	
	@Autowired
	private TipoFaseService faseService;
	
	@GetMapping("/tipoFase")
	public ResponseEntity<List<TipoFaseResponse>> listaFase(){
		return ResponseEntity.ok(faseService.listaFase());
	}
	
	@PutMapping("/modificarFase/{id}")
	public void modificarFase(@PathVariable int id, @RequestBody DetalleFaseRequest detalleReq) {
		faseService.modificarFase(id, detalleReq);
	}
	
	@PostMapping("/crearFase")
	public void crearFase(@RequestBody DetalleFaseRequest fase) {
		faseService.crearFase(fase);
	}
}
