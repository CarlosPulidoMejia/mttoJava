package com.bim.reporte.mantenimiento.request;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleFaseRequest {
	private int id_fase;
	private boolean status;
	private String tipo_fase_vch;
}
