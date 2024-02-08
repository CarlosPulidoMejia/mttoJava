package com.bim.reporte.mantenimiento.service;

import java.util.List;

import com.bim.reporte.mantenimiento.request.DetalleEstadoProyectoRequest;
import com.bim.reporte.mantenimiento.response.TipoEstadoProyectoResponse;

public interface TipoEstadoProyectoService {

	public List<TipoEstadoProyectoResponse> listaEstado();
	
	public void crearEstado(DetalleEstadoProyectoRequest estado);
	
	public void modificarEstado (int id, DetalleEstadoProyectoRequest detallEstado);
}
