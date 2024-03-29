package com.bim.reporte.mantenimiento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="cat_tipo_proyecto")
@AllArgsConstructor
@Data
public class CatTipoProyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_proyecto")
	public int idTipoProyecto;

	@Column(name = "tipo_proyecto_vch")
	public String tipoProyecto;
	
	public Boolean status;
	
	public CatTipoProyecto() {
		// TODO Auto-generated constructor stub
	}
}
