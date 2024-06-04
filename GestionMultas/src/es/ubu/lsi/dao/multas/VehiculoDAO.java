package es.ubu.lsi.dao.multas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Vehiculo;

public class VehiculoDAO extends JpaDAO<Vehiculo, String>{

	public VehiculoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vehiculo> findAll() {
		// TODO Auto-generated method stub
		return getEntityManager().createNamedQuery("Vehiculo.findAll", Vehiculo.class).getResultList();
	}
}
