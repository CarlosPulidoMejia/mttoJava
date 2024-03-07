package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatTipoTicket;
import com.bim.reporte.mantenimiento.response.TipoDependenciaResponse;
import com.bim.reporte.mantenimiento.response.TipoTicketResponse;
import com.bim.reporte.mantenimiento.service.TipoTicketService;
import com.bim.reporte.mantenimiento.repository.CatTipoTicketRepo;

@Service
public class TipoTicketServiceImpl implements TipoTicketService {
	
	@Autowired
	private CatTipoTicketRepo catTipoTicketRepo;
	@Override
	public List<TipoTicketResponse> listaTipoTicket() {
		// TODO Auto-generated method stub
		List<CatTipoTicket> listTicket = catTipoTicketRepo.findAll();
		
		List<TipoTicketResponse> listaTipoResponse = listTicket.stream()
				.map(lstTkt ->
				new TipoTicketResponse(lstTkt.getIdTipoTicket(), lstTkt.getStatus(), lstTkt.getTipoTicket())
				).collect(Collectors.toList());
		return listaTipoResponse;
	}
	
}
