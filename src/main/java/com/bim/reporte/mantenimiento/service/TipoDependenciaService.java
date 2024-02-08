package com.bim.reporte.mantenimiento.service;

import java.util.List;

import com.bim.reporte.mantenimiento.response.TipoDependenciaResponse;
import com.bim.reporte.mantenimiento.request.DetalleDependenciaRequest;

public interface TipoDependenciaService {

	public List<TipoDependenciaResponse> listaDependencia();
	
	public void crearDependencia(DetalleDependenciaRequest dependencia);
	
	public void modificarDependencia (int idDependencia, DetalleDependenciaRequest detallDependencia);
}
