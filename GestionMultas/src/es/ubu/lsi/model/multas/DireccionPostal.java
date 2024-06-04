package es.ubu.lsi.model.multas;

import javax.persistence.Column;

@Embeddable
public class DireccionPostal {

	@Column(name="DIRECCION")
	private String dirreccion;
	@Column(name="CP")
	private String cp;
	@Column(name="CIUDAD")
	private String ciudad;
	
}
