package es.ubu.lsi.model.multas;

import java.io.Serializable;

@Entity
@NamedQueries({
	@NamedQuery(name="Incidencia.findAll", query="select i from Incidencia i"),
	@NamedQuery(name="Incidencia.findByConductor", query="select i from Incidencia i where i.conductor.nif = :nif")
	})
public class Incidencia {

	@EmbeddedId
	private IncidenciaPK id;
	
	private String anotacion;
	
	@ManyToOne
	@MapsId("nif")
	@JoinColumn(name = "nif")
	private Conductor conductor;
	
	@ManyToOne
	@JoinColumn(name = "idtipo")
	@OrderBy("id.fecha ASC")
	private TipoIncidencia tipoIncidencia;

	public Incidencia() {
		
		
	}
	

	public IncidenciaPK getId() {
		return id;
	}


	public void setId(IncidenciaPK id) {
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
public class IncidenciaPK implements Serializable {

	private Date fecha;
		
	private String nif;

	public IncidenciaPK() {
		
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
