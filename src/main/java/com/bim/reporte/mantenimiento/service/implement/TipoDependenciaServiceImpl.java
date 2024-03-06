package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatDependencias;
import com.bim.reporte.mantenimiento.repository.CatDependenciaRepo;
import com.bim.reporte.mantenimiento.request.DetalleDependenciaRequest;
import com.bim.reporte.mantenimiento.response.TipoDependenciaResponse;
import com.bim.reporte.mantenimiento.service.TipoDependenciaService;

@Service
public class TipoDependenciaServiceImpl implements TipoDependenciaService{

	@Autowired
	private CatDependenciaRepo catDependenciaRepo;
	@Override
	public List<TipoDependenciaResponse> listaDependencia() {
		// TODO Auto-generated method stub
		List<CatDependencias> listaDep = catDependenciaRepo.findAll();
		
		List<TipoDependenciaResponse> listaDepResponse = listaDep.stream()
				.map(lstDep ->
				new TipoDependenciaResponse(lstDep.getIdDependencia(), lstDep.getStatus(), lstDep.getTipoDependencia())
				//new TipoDependenciaResponse(lstDep.getIdDependencia(), lstDep.getTipoDependencia()
				//		)
				).collect(Collectors.toList());
		return listaDepResponse;
	}
	
	public void modificarDependencia (int idDependencia, DetalleDependenciaRequest detallDependenciaRequest) {
		// TODO Auto-generated method stub
		//int detalleDependencia = catDependenciaRepo.obtenerDetalle(idDependencia);
		Optional<CatDependencias> detDependencia = catDependenciaRepo.findById(idDependencia);
		if(detDependencia != null) {
			CatDependencias detDepEnt = detDependencia.get();
			detDepEnt.setTipoDependencia(detallDependenciaRequest.getTipo_dependencia_vch());
			detDepEnt.setStatus(detallDependenciaRequest.isStatus());
			
			catDependenciaRepo.save(detDepEnt);
		}
	}
	
	public void crearDependencia (DetalleDependenciaRequest dependencia) {
		// TODO Auto-generated method stub
		if(dependencia != null) {
			CatDependencias nuevaDepEnt = new CatDependencias(); 
			nuevaDepEnt.setStatus(dependencia.isStatus());
			nuevaDepEnt.setTipoDependencia(dependencia.getTipo_dependencia_vch());
			
			catDependenciaRepo.save(nuevaDepEnt);
		}
	}

}
