package es.ubu.lsi.model.multas;

import java.util.HashSet;

@Entity
@NamedQuery(name="Vehiculo.findAll", query="select v from Vehiculo v")
public class Vehiculo {
	
	@Id
	@SequenceGenerator(name="Vehiculoaidauto_Gen", sequenceName="Vehiculo_Seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Vehiculoidauto_Gen")
	private String idauto;
	
	private String nombre;

	@Embedded
	private DireccionPostal direccionPostal;

	
	@OneToMany(mappedBy="vehiculo",fetch = FetchType.LAZY)
	private Set<Conductor> conductores;
	
	public Vehiculo() {
		
		conductores = new HashSet<Conductor>();
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

	public void setConductoree(Set<Conductor> conductores) {
		this.conductores = conductores;
	}

	@Override
	public String toString() {
		return "Vehiculo [idAuto=" + idauto + ", nombre=" + nombre + ", direccionPostal=" + direccionPostal
				+ ", conductoree=" + conductores + "]";
	}
}
