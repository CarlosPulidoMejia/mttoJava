package com.bim.reporte.mantenimiento.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDocumentacionResponse {

	private int idDocumentacion;
	private boolean status;
	private String documentacion;
}
