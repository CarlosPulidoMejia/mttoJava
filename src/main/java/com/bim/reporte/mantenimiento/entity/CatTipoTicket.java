package com.bim.reporte.mantenimiento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="cat_tipoTicket")
@Data
public class CatTipoTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipoTicket")
	public int idTipoTicket;

	@Column(name = "tipo_tipoTicket_vch")
	public String tipoTicket;
	
	public Boolean status;
}
