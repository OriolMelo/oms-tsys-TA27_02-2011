package oms.UD27.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.UD27.dto.Proyecto;
import oms.UD27.services.ProyectoServiceImpl;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	
	@GetMapping("/all")
	public List<Proyecto> listarProyectos(){
		return proyectoServiceImpl.listarProyectos();
	}
	
	
	@PostMapping("/add")
	public Proyecto salvarProyecto(@RequestBody Proyecto proyecto) {
		
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	
	
	@GetMapping("/{id}")
	public Proyecto ProyectoXID(@PathVariable(name="id") String id) {
		
		Proyecto Proyecto_xid= new Proyecto();
		
		Proyecto_xid=proyectoServiceImpl.proyectoXID(id);
		
		System.out.println("Proyecto XID: "+Proyecto_xid);
		
		return Proyecto_xid;
	}
	
	@PutMapping("/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto Proyecto) {
		
		Proyecto Proyecto_seleccionado= new Proyecto();
		Proyecto Proyecto_actualizado= new Proyecto();
		
		Proyecto_seleccionado= proyectoServiceImpl.proyectoXID(id);

		Proyecto_seleccionado.setId(Proyecto.getId());
		Proyecto_seleccionado.setNombre(Proyecto.getNombre());
		Proyecto_seleccionado.setHoras(Proyecto.getHoras());
		
		Proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(Proyecto_seleccionado);
		
		System.out.println("El Proyecto actualizado es: "+ Proyecto_actualizado);
		
		return Proyecto_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarProyecto(@PathVariable(name="id")String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}
}
