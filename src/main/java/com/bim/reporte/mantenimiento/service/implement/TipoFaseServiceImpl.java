package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bim.reporte.mantenimiento.entity.CatFase;
import com.bim.reporte.mantenimiento.repository.CatFaseRepo;
import com.bim.reporte.mantenimiento.request.DetalleFaseRequest;
import com.bim.reporte.mantenimiento.response.TipoFaseResponse;
import com.bim.reporte.mantenimiento.service.TipoFaseService;

@Service
public class TipoFaseServiceImpl implements TipoFaseService {

	@Autowired
	private CatFaseRepo catFaseRepo;
	
	@Override
	public List<TipoFaseResponse> listaFase() {
		// TODO Auto-generated method stub
		List<CatFase> listaFase = catFaseRepo.findAll();
		
		List<TipoFaseResponse> listaFaseResponse = listaFase.stream()
				.map(lstFase ->
				new TipoFaseResponse(lstFase.getIdTipoFase(), 
						lstFase.getTipoFase()
						)
				).collect(Collectors.toList());
		return listaFaseResponse;
	}
	
	public void modificarFase(int idFase, DetalleFaseRequest detalleReq) {
		// TODO Auto-generated method stub
		Optional<CatFase> detFase = catFaseRepo.findById(idFase);
		if(detFase != null) {
			CatFase detFasEnt = detFase.get();
			detFasEnt.setStatus(detalleReq.isStatus());
			detFasEnt.setTipoFase(detalleReq.getTipo_fase_vch());
			
			catFaseRepo.save(detFasEnt);
		}
	}
	
	public void crearFase(DetalleFaseRequest fase) {
		if(fase != null) {
			CatFase nuevaFasEnt = new CatFase();
			nuevaFasEnt.setStatus(fase.isStatus());
			nuevaFasEnt.setTipoFase(fase.getTipo_fase_vch());
			
			catFaseRepo.save(nuevaFasEnt);
		}
	}
}
