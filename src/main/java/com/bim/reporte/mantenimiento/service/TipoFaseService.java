package com.bim.reporte.mantenimiento.service;

import java.util.List;

import com.bim.reporte.mantenimiento.request.DetalleFaseRequest;
import com.bim.reporte.mantenimiento.response.TipoFaseResponse;

public interface TipoFaseService {

	public List<TipoFaseResponse> listaFase();
	
	public void crearFase(DetalleFaseRequest fase);
	
	public void modificarFase(int idFase, DetalleFaseRequest detalleReq); 
}
