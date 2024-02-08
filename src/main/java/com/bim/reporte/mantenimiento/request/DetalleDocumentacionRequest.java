package com.bim.reporte.mantenimiento.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class DetalleDocumentacionRequest {
	private int id_documentacion;
	private boolean status;
	private String tipo_documentacion_vch;
}
