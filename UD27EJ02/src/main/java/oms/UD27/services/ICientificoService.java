package oms.UD27.services;

import java.util.List;

import oms.UD27.dto.Cientifico;

public interface ICientificoService {
	//Metodos del CRUD
			public List<Cientifico> listarCientifico(); //Listar All 
			
			public Cientifico guardarCientifico(Cientifico cientifico);	//Guarda un cientifico CREATE
			
			public Cientifico cientificoXID(String id); //Leer datos de un cientifico READ
			
			public Cientifico actualizarCientifico(Cientifico cientifico); //Actualiza datos del cientifico UPDATE
			
			public void eliminarCientifico(String id);// Elimina el cientifico DELETE
}
