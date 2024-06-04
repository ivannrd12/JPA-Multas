package es.ubu.lsi.model.multas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Tipoincidencia.findAll", query="selec t from TIPOINCIDENCIA t")
public class TipoIncidencia {

	@Id
	private Long id;
	
	private String descripcion;
	
	private int valor;
	
	@OneToMany(mappedBy="tipoincidencia")
	private List<Incidencia> incidencias;

	public TipoIncidencia() {
		
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

	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	@Override
	public String toString() {
		return "TipoIncidencia [id=" + id + ", descripcion=" + descripcion + ", valor=" + valor + ", incidencias="
				+ incidencias + "]";
	}
}
