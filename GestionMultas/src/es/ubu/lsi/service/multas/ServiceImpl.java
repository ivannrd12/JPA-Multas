package es.ubu.lsi.service.multas;

import java.util.Date;

public class ServiceImpl extends PersistenceService implements Service {

	
	public ServiceImpl() {
		
		
	}
	
	

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		// TODO Auto-generated method stub
	
		EntityManager em = null;
		
		try {
			
			em = PersistenceFactorySingleton.getEntityManager();
			
	        em.getTransaction().begin();
	       
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
			
			em.persist(incidencia);
			
			em.merge(conductor);
			
			
			em.getTransaction().commit();
			
		} catch (IncidentException e) {
			
			e.getError();
			System.out.println("Probando el servicio...");

		}
		
		
		
		catch (Exception e) {
			
			if (em != null) {
				

				
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
	        
	    	em = PersistenceFactorySingleton.getEntityManager();
			
	        em.getTransaction().begin();
	        
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
	        
	        em.getTransaction().commit();
	        
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
