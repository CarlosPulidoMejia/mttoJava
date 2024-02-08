package com.bim.reporte.mantenimiento.service;

import java.util.List;

import com.bim.reporte.mantenimiento.request.DetalleDocumentacionRequest;
import com.bim.reporte.mantenimiento.response.TipoDocumentacionResponse;

public interface TipoDocumentacionService {

	public List<TipoDocumentacionResponse> listaDocumentacion();
	
	public void crearDocumentacion (DetalleDocumentacionRequest documentacion);
	
	public void modificarDocumentacion (int idDocumentacion, DetalleDocumentacionRequest detalleDocumentacion);
}
