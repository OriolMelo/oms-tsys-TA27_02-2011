package oms.UD27.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cientificos")
public class Cientifico {
	@Id
	@Column(name = "DNI")
	private String dni;
	@Column(name = "Nom_Apels")
	private String nombre_completo;
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "asignado_a",
        joinColumns = { @JoinColumn(name = "cientifico") },
        inverseJoinColumns = { @JoinColumn(name = "proyecto") }
    )
	@JsonIgnoreProperties("cientificos")
	private List<Proyecto> proyectos = new ArrayList<>();
	
	public Cientifico() {
		
	}
	
	public Cientifico(String dni, String nombre_completo, List<Proyecto> proyectos) {
		super();
		this.dni = dni;
		this.nombre_completo = nombre_completo;
		this.proyectos = proyectos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
}
