package oms.UD27.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import oms.UD27.dto.Cientifico;
import oms.UD27.dto.Proyecto;
import oms.UD27.services.CientificoServiceImpl;
import oms.UD27.services.ProyectoServiceImpl;

@RestController
@RequestMapping("/cientificos")
public class CientificoController {
	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	
	@Autowired
    private EntityManager entityManager;
	
	@GetMapping("/all")
	public List<Cientifico> listarCientifico(){
		return cientificoServiceImpl.listarCientifico();
	}
	
	
	@PostMapping("/add")
	public Cientifico salvarCientifico(@RequestBody Cientifico cientifico) {
		
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}
	
	
	@GetMapping("/{DNI}")
	public Cientifico CientificoXID(@PathVariable(name="DNI") String id) {
		
		Cientifico Cientifico_xid= new Cientifico();
		
		Cientifico_xid=cientificoServiceImpl.cientificoXID(id);
		
		System.out.println("Cientifico XID: "+Cientifico_xid);
		
		return Cientifico_xid;
	}
	
	@PutMapping("/{DNI}")
	public Cientifico actualizarCientifico(@PathVariable(name="DNI")String id,@RequestBody Cientifico Cientifico) {
		
		Cientifico Cientifico_seleccionado= new Cientifico();
		Cientifico Cientifico_actualizado= new Cientifico();
		
		Cientifico_seleccionado= cientificoServiceImpl.cientificoXID(id);

		Cientifico_seleccionado.setDni(Cientifico.getDni());
		Cientifico_seleccionado.setNombre_completo(Cientifico.getNombre_completo());
		
		Cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(Cientifico_seleccionado);
		
		System.out.println("El Cientifico actualizado es: "+ Cientifico_actualizado);
		
		return Cientifico_actualizado;
	}
	
	@DeleteMapping("/{DNI}")
	public void eliminarCientifico(@PathVariable(name="DNI")String id) {
		cientificoServiceImpl.eliminarCientifico(id);
	}
	
	@PostMapping("/asignar-a/{id}")
	@Transactional
	public ResponseEntity<String> salvarCientificoCurso(@RequestBody Cientifico cientifico, @PathVariable(name="id") String id) {
	    // Guarda el cientifico
	    Cientifico cientificoGuardado = cientificoServiceImpl.guardarCientifico(cientifico);

	    // Obtiene el curso por su ID
	    Proyecto proyecto = proyectoServiceImpl.proyectoXID(id);

	    // Asocia el cientifico con el curso
	    if (proyecto != null) {
	        cientificoGuardado.getProyectos().add(proyecto);
	        proyecto.getCientificos().add(cientificoGuardado);
	        entityManager.persist(cientificoGuardado);
	        entityManager.persist(proyecto);
	    }

	    return ResponseEntity.ok("Cientifico asociado con éxito al curso");
	    
	}
}
