package com.bim.reporte.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bim.reporte.mantenimiento.entity.CatDependencias;

public interface CatDependenciaRepo extends JpaRepository<CatDependencias, Integer>{
	
	/*@Query(value = "SELECT id_detalle FROM detalle_proyecto WHERE id_proyecto=:idProyecto",nativeQuery = true)
	int obtenerDetalle(int idDependencia);*/
}
