package com.bim.reporte.mantenimiento.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoEstadoProyectoResponse {

	public int idTipoEstado;
	public boolean status;
	public String tipoEstado;
}
