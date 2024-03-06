package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatEstadoProyecto;
import com.bim.reporte.mantenimiento.repository.CatEstadoProyectoRepo;
import com.bim.reporte.mantenimiento.request.DetalleEstadoProyectoRequest;
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
				new TipoEstadoProyectoResponse(lstEstado.getIdTipoEstado(), lstEstado.getStatus(),
						lstEstado.getTipoEstado()
						)
				).collect(Collectors.toList());
		return listaEstadoResponse;
	}
	
	public void modificarEstado (int id, DetalleEstadoProyectoRequest detallEstado) {
		//TODO Auto-generated method stub
		Optional<CatEstadoProyecto> detEstado = catEstadoProyectoRepo.findById(id);
		if(detEstado != null) {
			CatEstadoProyecto detEstEnt = detEstado.get();
			detEstEnt.setStatus(detallEstado.isStatus());
			detEstEnt.setTipoEstado(detallEstado.getTipo_estado_vch());
			
			catEstadoProyectoRepo.save(detEstEnt);
		}
	}
	
	public void crearEstado (DetalleEstadoProyectoRequest estado) {
		//TODO Auto-generated method stub
		if(estado != null) {
			CatEstadoProyecto estadoEnt = new CatEstadoProyecto();
			estadoEnt.setStatus(estado.isStatus());
			estadoEnt.setTipoEstado(estado.getTipo_estado_vch());
			
			catEstadoProyectoRepo.save(estadoEnt);
		}
	}

}
