package es.ubu.lsi.dao.multas;

import java.util.List;

import javax.persistence.EntityManager;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Conductor;

public class ConductorDao extends JpaDAO<Conductor, String>{

	public ConductorDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Conductor> findAll() {
		// TODO Auto-generated method stub
		return getEntityManager().createNamedQuery("Conductor.findAll", Conductor.class).getResultList();

	}

}
