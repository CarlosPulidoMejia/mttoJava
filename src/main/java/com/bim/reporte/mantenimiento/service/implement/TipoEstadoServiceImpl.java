package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatEstadoProyecto;
import com.bim.reporte.mantenimiento.repository.CatEstadoProyectoRepo;
import com.bim.reporte.mantenimiento.response.TipoEstadoProyectoResponse;
import com.bim.reporte.mantenimiento.service.TipoEstadoProyectoService;

@Service
public class TipoEstadoServiceImpl implements TipoEstadoProyectoService {

	@Autowired
	private CatEstadoProyectoRepo catEstadoProyectoRepo;
	
	@Override
	public List<TipoEstadoProyectoResponse> listaEstado() {
		// TODO Auto-generated method stub
		List<CatEstadoProyecto> listaEstado = catEstadoProyectoRepo.findAll();
		
		List<TipoEstadoProyectoResponse> listaEstadoResponse = listaEstado.stream()
				.map(lstEstado -> 
				new TipoEstadoProyectoResponse(lstEstado.getIdTipoEstado(), 
						lstEstado.getTipoEstado()
						)
				).collect(Collectors.toList());
		return listaEstadoResponse;
	}

}
