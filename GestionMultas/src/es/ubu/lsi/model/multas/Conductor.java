package es.ubu.lsi.model.multas;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conductor {

	@Id
	private String nif;
	
	private String nombre;
	
	private String apellido;
	
	@Embedded
	private DireccionPostal direccionPostal;
	
	private int puntos;
	
	@ManyToOne
	@JoinColumn(name = "idauto")
	private Vehiculo vehiculo;
	
}
