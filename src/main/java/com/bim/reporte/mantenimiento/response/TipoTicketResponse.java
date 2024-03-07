package com.bim.reporte.mantenimiento.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoTicketResponse {
	public int idTipoTicket;
	public boolean status;
	public String tipoTicket;
}
