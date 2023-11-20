package oms.UD27.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD27.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, String>{
	
}
