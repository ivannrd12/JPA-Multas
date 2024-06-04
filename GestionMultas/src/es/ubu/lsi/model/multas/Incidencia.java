package es.ubu.lsi.model.multas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Incidencia.findAll", query="select i from Incidencia i")
public class Incidencia {

	@EmbeddedId
	private IncidenciaPk id;
	
	private String anotacion;
	
	@ManyToOne
	@MapsId("nif")
	@JoinColumn(name = "nif")
	private Conductor conductor;
	
	@ManyToOne
	@JoinColumn(name = "idtipo")
	private TipoIncidencia tipoIncidencia;

	public Incidencia() {
		
	}
	
	public IncidenciaPk getId() {
		return id;
	}


	public void setId(IncidenciaPk id) {
		this.id = id;
	}


	public String getAnotacion() {
		return anotacion;
	}


	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}


	public Conductor getConductor() {
		return conductor;
	}


	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}


	public TipoIncidencia getTipoIncidencia() {
		return tipoIncidencia;
	}


	public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}


@Embeddable
public class IncidenciaPk implements Serializable {

	private Date fecha;
		
	private String nif;

	public IncidenciaPk() {
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	
}	
	
	
}
