package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatTipoProyecto;
import com.bim.reporte.mantenimiento.repository.CatTipoProyectoRepo;
import com.bim.reporte.mantenimiento.request.DetalleTipoProyectoRequest;
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
				new TipoProyectoResponse(tipoProy.getIdTipoProyecto(), tipoProy.getStatus(), tipoProy.getTipoProyecto()
						)
				).collect(Collectors.toList());
		
		return lstTipoProy;
				
	}
	
	public void modificarTipoProyecto(int idTipoProyecto, DetalleTipoProyectoRequest detallTipoProyecto) {
		Optional<CatTipoProyecto> detTipoProy = catTipoProyectoRepo.findById(idTipoProyecto);
		if(detTipoProy != null) {
			CatTipoProyecto detTipProyEnt = detTipoProy.get();
			detTipProyEnt.setStatus(detallTipoProyecto.isStatus());
			detTipProyEnt.setTipoProyecto(detallTipoProyecto.getTipo_proyecto_vch());
			
			catTipoProyectoRepo.save(detTipProyEnt);
		}
	}
	
	public void crearTipoProyecto(DetalleTipoProyectoRequest tipoProyecto) {
		if(tipoProyecto != null) {
			CatTipoProyecto nuevoTipProyEnt = new CatTipoProyecto();
			nuevoTipProyEnt.setStatus(tipoProyecto.isStatus());
			nuevoTipProyEnt.setTipoProyecto(tipoProyecto.getTipo_proyecto_vch());
			
			catTipoProyectoRepo.save(nuevoTipProyEnt);
		}
	}
}
