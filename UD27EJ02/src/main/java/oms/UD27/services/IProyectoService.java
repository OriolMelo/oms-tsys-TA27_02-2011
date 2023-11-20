package oms.UD27.services;

import java.util.List;

import oms.UD27.dto.Proyecto;

public interface IProyectoService {
	//Metodos del CRUD
	public List<Proyecto> listarProyectos(); //Listar All 
	
	public Proyecto guardarProyecto(Proyecto proyecto);	//Guarda un proyecto CREATE
	
	public Proyecto proyectoXID(String id); //Leer datos de un proyecto READ
	
	public Proyecto actualizarProyecto(Proyecto proyecto); //Actualiza datos del proyecto UPDATE
	
	public void eliminarProyecto(String id);// Elimina el proyecto DELETE
}
