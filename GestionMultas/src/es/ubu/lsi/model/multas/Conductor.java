package es.ubu.lsi.model.multas;

import java.util.HashSet;

@Entity
@Table(name ="CONDUCTOR")
@NamedQueries({
	@NamedQuery(name="Conductor.findAll", query="select c from Conductor c"),
	@NamedQuery(name="Conductor.findByNif", query="select c from Conductor c where c.nif = nif")
	})
public class Conductor {

	@Id
	@Column(name="NIF")
	private String nif;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDO")
	private String apellido;
	
	@Embedded
	@Column(name="DIRECCION")
	private DireccionPostal direccionPostal;
	@Column(name="PUNTOS")
	private int puntos;
	
	@ManyToOne
	@JoinColumn(name = "IDAUTO")
	private Vehiculo vehiculo;
	
	@OneToMany(mappedBy = "conductor")
	@OrderBy("id.fecha ASC")
	private Set<Incidencia> incidencias;
	
	public Conductor() {
		
		incidencias = new HashSet<Incidencia>();
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
