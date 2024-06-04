package es.ubu.lsi.model.multas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo {

	@Id
	private String idAuto;
	
	private String nombre;

	@Embedded
	private DireccionPostal direccionPostal;
	
}

