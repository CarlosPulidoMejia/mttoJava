package com.bim.reporte.mantenimiento.response;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoProyectoResponse {
	public int idTipoProyecto;
	public boolean status;
	public String tipoProyecto;
	
}
