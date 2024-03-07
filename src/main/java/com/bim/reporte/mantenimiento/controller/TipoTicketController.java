package com.bim.reporte.mantenimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.mantenimiento.response.TipoTicketResponse;
import com.bim.reporte.mantenimiento.service.TipoTicketService;



@RestController
@CrossOrigin("*")
@RequestMapping("catalogos")
public class TipoTicketController {
	
	@Autowired
	private TipoTicketService ticketService;
	
	@GetMapping("/tipoTickiet")
	public ResponseEntity<List<TipoTicketResponse>> listaTipoTicket(){
		return ResponseEntity.ok(ticketService.listaTipoTicket());
	}
	
}
