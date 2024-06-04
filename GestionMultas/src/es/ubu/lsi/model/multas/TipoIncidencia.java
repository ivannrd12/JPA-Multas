package es.ubu.lsi.model.multas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoIncidencia {

	@Id
	private Long id;
	
	private String descripcion;
	
	private int valor;
	
	
}
