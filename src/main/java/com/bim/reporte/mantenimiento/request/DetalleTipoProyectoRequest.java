package com.bim.reporte.mantenimiento.request;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleTipoProyectoRequest {
	private int id_tipo_proyecto;
	private boolean status;
	private String tipo_proyecto_vch;
}
