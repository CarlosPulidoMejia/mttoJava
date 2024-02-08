package com.bim.reporte.mantenimiento.service;

import java.util.List;

import com.bim.reporte.mantenimiento.request.DetalleTipoProyectoRequest;
import com.bim.reporte.mantenimiento.response.TipoProyectoResponse;

public interface TipoProyectoService {

	public List<TipoProyectoResponse> listarTipoProyecto();
	
	public void crearTipoProyecto(DetalleTipoProyectoRequest tipoProyecto);
	
	public void modificarTipoProyecto(int idTipoProyecto, DetalleTipoProyectoRequest detallTipoProyecto); 
}
