package es.ubu.lsi.dao.multas;

import java.util.List;

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
