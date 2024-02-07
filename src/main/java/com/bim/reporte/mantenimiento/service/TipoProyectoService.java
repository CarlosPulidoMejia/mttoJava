package com.bim.reporte.mantenimiento.service;

import java.util.List;

import com.bim.reporte.mantenimiento.entity.CatTipoProyecto;
import com.bim.reporte.mantenimiento.response.TipoProyectoResponse;

public interface TipoProyectoService {

	public List<TipoProyectoResponse> listarTipoProyecto();
}
