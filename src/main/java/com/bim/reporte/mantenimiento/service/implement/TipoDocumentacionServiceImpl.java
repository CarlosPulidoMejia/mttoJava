package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatDocumentacion;
import com.bim.reporte.mantenimiento.repository.CatDocumentacionRepo;
import com.bim.reporte.mantenimiento.request.DetalleDocumentacionRequest;
import com.bim.reporte.mantenimiento.response.TipoDocumentacionResponse;
import com.bim.reporte.mantenimiento.service.TipoDocumentacionService;

@Service
public class TipoDocumentacionServiceImpl implements TipoDocumentacionService{

	@Autowired
	private CatDocumentacionRepo catDocumentacionRepo;
	@Override
	public List<TipoDocumentacionResponse> listaDocumentacion() {
		// TODO Auto-generated method stub
		List<CatDocumentacion> listaDoc = catDocumentacionRepo.findAll();
		
		List<TipoDocumentacionResponse> listaDocResponse = listaDoc.stream()
				.map(lstDoc ->
				new TipoDocumentacionResponse(
						lstDoc.getIdDocumentacion(),
						lstDoc.getTipoDocumentacion())).collect(Collectors.toList());
			
		return listaDocResponse;
	}
	
	public void modificarDocumentacion (int idDocumentacion, DetalleDocumentacionRequest detalleDocumentacion) {
		// TODO Auto-generated method stub
		Optional<CatDocumentacion> detDocumentacion = catDocumentacionRepo.findById(idDocumentacion);
		if(detDocumentacion != null) {
			CatDocumentacion detDocEnt = detDocumentacion.get();
			detDocEnt.setTipoDocumentacion(detalleDocumentacion.getTipo_documentacion_vch());
			detDocEnt.setStatus(detalleDocumentacion.isStatus());
			
			catDocumentacionRepo.save(detDocEnt);
		}
	}
	
	public void crearDocumentacion (DetalleDocumentacionRequest documentacion) {
		// TODO Auto-generated method stub
		if(documentacion != null) {
			CatDocumentacion nuevaDocEnt = new CatDocumentacion();
			nuevaDocEnt.setStatus(documentacion.isStatus());
			nuevaDocEnt.setTipoDocumentacion(documentacion.getTipo_documentacion_vch());
			
			catDocumentacionRepo.save(nuevaDocEnt);
		}
	}
}
