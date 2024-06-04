package es.ubu.lsi.service.multas;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import es.ubu.lsi.dao.multas.ConductorDAO;
import es.ubu.lsi.dao.multas.IncidenciaDAO;
import es.ubu.lsi.dao.multas.TipoIncidenciaDAO;
import es.ubu.lsi.model.multas.Conductor;
import es.ubu.lsi.model.multas.Incidencia;
import es.ubu.lsi.model.multas.Incidencia.IncidenciaPK;
import es.ubu.lsi.model.multas.TipoIncidencia;
import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.PersistenceService;


public class ServiceImpl extends PersistenceService implements Service {

	
	public ServiceImpl() {
		
	}

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		
		try {
	        
			em = this.createSession();
	    
	        beginTransaction(em);
	        
	        ConductorDAO conductorDAO = new ConductorDAO(em);
	    	
	    	TipoIncidenciaDAO tipoIncidenciaDAO = new TipoIncidenciaDAO(em);
	    	
	    	IncidenciaDAO incidenciaDAO = new IncidenciaDAO(em);
	    	
			Conductor conductor = conductorDAO.findByNif(nif);
			
			TipoIncidencia tipoIncidencia = tipoIncidenciaDAO.findById(tipo);
			
			if(conductor == null ) {
				
				throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
				
			} else if (tipoIncidencia == null) {
				
				throw new IncidentException(IncidentError.NOT_EXIST_INCIDENT_TYPE);
			}
			
			int puntosRestantes = conductor.getPuntos() - tipoIncidencia.getValor();
			
			if (puntosRestantes < 0) {
				
				throw new IncidentException(IncidentError.NOT_AVAILABLE_POINTS);
			}
			
			conductor.setPuntos(puntosRestantes);
			
			Incidencia incidencia = new Incidencia();
			
			IncidenciaPK id = incidencia.new IncidenciaPK();
			
			id.setFecha(fecha);
			
			id.setNif(nif);
			
			incidencia.setId(id);
			
			incidencia.setConductor(conductor);
			
			incidencia.setTipoIncidencia(tipoIncidencia);
			
			incidencia.setAnotacion("");
			
			incidenciaDAO.persist(incidencia);
			
			conductorDAO.notify();
			
			commitTransaction(em);
			
		} catch (Exception e) {
			
			if (em != null) {
				
				rollbackTransaction(em);
	        }
			
			throw new PersistenceException("Error al insertar la incidencia", e);
        
		} finally {
			
			if (em != null) {
				
            em.close();
        }
    }
	}

	@Override
	public void indultar(String nif) throws PersistenceException {
		// TODO Auto-generated method stub
	
		//List<Incidencia> incidencias = incidenciaDAO.findByConductor(nif)
		
		EntityManager em = null;
		
	    try {
	        
	        em = this.createSession();
	    
	        beginTransaction(em);
	        
	        ConductorDAO conductorDAO = new ConductorDAO(em);
	        
	        IncidenciaDAO incidenciaDAO = new IncidenciaDAO(em);
	        
			Conductor conductor = conductorDAO.findByNif(nif);
	        
	        
	        if (conductor == null) {
	        	throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
	        }
	        
	        conductor.setPuntos(12);

	        List<Incidencia> incidencias = incidenciaDAO.findByConductor(nif);
	        
	        
	        for (Incidencia incidencia : incidencias) {
	        	
	            incidenciaDAO.remove(incidencia);
	        }
	        
	        commitTransaction(em);
	        
	    } catch (Exception e) {
	    	
	        rollbackTransaction(em);
	        
	        throw new PersistenceException("Error al indultar al conductor.", e);
	        
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
		
		
	}

	@Override
	public List<Vehiculo> consultarVehiculos() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

}
