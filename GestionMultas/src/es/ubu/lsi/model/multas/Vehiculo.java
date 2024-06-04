package es.ubu.lsi.model.multas;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name="Vehiculo.findAll", query="select v from Vehiculo v")
public class Vehiculo {
	
	@Id
	@SequenceGenerator(name="VehiculoIdAuto_Gen", sequenceName="Vehiculo_Seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VehiculoIdAuto_Gen")
	private String idAuto;
	
	private String nombre;

	@Embedded
	private DireccionPostal direccionPostal;

	
	@OneToMany(mappedBy="vehiculo")
	private Set<Conductor> conductores;
	
	public Vehiculo() {
	}

	public String getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(String idAuto) {
		this.idAuto = idAuto;
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

	public Set<Conductor> getConductoree() {
		return conductores;
	}

	public void setConductoree(Set<Conductor> conductoree) {
		this.conductores = conductoree;
	}

	@Override
	public String toString() {
		return "Vehiculo [idAuto=" + idAuto + ", nombre=" + nombre + ", direccionPostal=" + direccionPostal
				+ ", conductoree=" + conductores + "]";
	}
}
