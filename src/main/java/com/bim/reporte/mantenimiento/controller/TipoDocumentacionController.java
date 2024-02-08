package com.bim.reporte.mantenimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.mantenimiento.request.DetalleDocumentacionRequest;
import com.bim.reporte.mantenimiento.response.TipoDocumentacionResponse;
import com.bim.reporte.mantenimiento.service.TipoDocumentacionService;

@RestController
@CrossOrigin("*")
@RequestMapping("catalogos")
public class TipoDocumentacionController {

	@Autowired
	private TipoDocumentacionService documentacionService;
	
	@GetMapping("/tipoDocumentacion")
	public ResponseEntity<List<TipoDocumentacionResponse>> listaDoc(){
		return ResponseEntity.ok(documentacionService.listaDocumentacion());
	}
	
	@PutMapping("/modificarDocumentacion/{id}")
	public void modificarDocumentacion (@PathVariable int id, @RequestBody DetalleDocumentacionRequest detalleReq) {
		documentacionService.modificarDocumentacion(id, detalleReq);
	}
	
	@PostMapping("crearDocumentacion")
	public void crearDocumentacion (@RequestBody DetalleDocumentacionRequest documentacion) {
		documentacionService.crearDocumentacion(documentacion);
	}
	
	
}
