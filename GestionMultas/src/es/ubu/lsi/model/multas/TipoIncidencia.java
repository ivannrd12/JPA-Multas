package es.ubu.lsi.model.multas;


import java.util.HashSet;

@Entity
@NamedQuery(name="Tipoincidencia.findAll", query="select t from TipoIncidencia t")
public class TipoIncidencia {

	@Id
	private Long id;
	
	private String descripcion;
	
	private int valor;
	
	@OneToMany(mappedBy="tipoIncidencia")
	private Set<Incidencia> incidencias;

	public TipoIncidencia() {
		
		incidencias = new HashSet<Incidencia>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	@Override
	public String toString() {
		return "TipoIncidencia [id=" + id + ", descripcion=" + descripcion + ", valor=" + valor + ", incidencias="
				+ incidencias + "]";
	}
}
