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

	@Override
	public String toString() {
		return "Conductor [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", direccionPostal="
				+ direccionPostal + ", puntos=" + puntos + ", vehiculo=" + vehiculo + "]";
	}

	
	
	
}
