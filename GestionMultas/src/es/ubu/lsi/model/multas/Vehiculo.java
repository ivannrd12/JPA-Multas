package es.ubu.lsi.model.multas;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Vehiculo.findAll", query="select v from Vehiculo v")
public class Vehiculo {
	
	@Id
	private String idauto;
	
	private String nombre;

	@Embedded
	private DireccionPostal direccionPostal;

	
	@OneToMany(mappedBy="vehiculo",fetch = FetchType.LAZY)
	private Set<Conductor> conductores;
	
	public Vehiculo() {
	}

	public String getIdAuto() {
		return idauto;
	}

	public void setIdAuto(String idauto) {
		this.idauto = idauto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DireccionPostal getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public Set<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Set<Conductor> conductores) {
		this.conductores = conductores;
	}

	@Override
	public String toString() {
		return "Vehiculo [idAuto=" + idauto + ", nombre=" + nombre + ", direccionPostal=" + direccionPostal
				+ ", conductores=" + conductores + "]";
	}
}
