package es.ubu.lsi.model.multas;

import javax.persistence.Embeddable;

@Embeddable
public class DireccionPostal{
	private String direccion;
   	private String cp;
    	private String ciudad;
    
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "DireccionPostal [direccion=" + direccion + ", cp=" + cp + ", ciudad=" + ciudad + "]";
	}
}
