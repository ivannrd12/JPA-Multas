package es.ubu.lsi.model.multas;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Conductor.findAll", query="select c from Conductor c")
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
	
	@OneToMany(mappedBy = "conductor" ,fetch = FetchType.LAZY)
	private Set<Incidencia> incidencias;
	
	public Conductor() {
		
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public DireccionPostal getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	@Override
	public String toString() {
		return "Conductor [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", direccionPostal="
				+ direccionPostal + ", puntos=" + puntos + ", vehiculo=" + vehiculo + "]";
	}

	
	
	
}
