package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatTipoProyecto;
import com.bim.reporte.mantenimiento.repository.CatTipoProyectoRepo;
import com.bim.reporte.mantenimiento.response.TipoProyectoResponse;
import com.bim.reporte.mantenimiento.service.TipoProyectoService;


@Service
public class TipoProyectoServiceImpl implements TipoProyectoService{

	@Autowired
	private CatTipoProyectoRepo catTipoProyectoRepo;
	
	@Override
	public List<TipoProyectoResponse> listarTipoProyecto() {
		// TODO Auto-generated method stub
		List<CatTipoProyecto> lista = catTipoProyectoRepo.findAll();
		
		List<TipoProyectoResponse> lstTipoProy = lista.stream()
				.map(tipoProy -> 
				new TipoProyectoResponse(tipoProy.getIdTipoProyecto(),tipoProy.getTipoProyecto()
						)
				).collect(Collectors.toList());
		
		return lstTipoProy;
				
	}

}
