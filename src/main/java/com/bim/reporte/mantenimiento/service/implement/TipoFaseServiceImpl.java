package com.bim.reporte.mantenimiento.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.mantenimiento.entity.CatFase;
import com.bim.reporte.mantenimiento.repository.CatFaseRepo;
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

}
